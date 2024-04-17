package mod.hisui.bees;

import mod.hisui.bees.item.BeeItem;
import mod.hisui.bees.registry.BeeTypeRegistry;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bees implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("bees");


	public static final BeeItem FOREST_BEE = Registry.register(Registries.ITEM, new Identifier("bees:forest"),
			new BeeItem(Identifier.of("bees","forest"),new Item.Settings()));
	public static final BeeItem ENDER_BEE = Registry.register(Registries.ITEM, new Identifier("bees:ender"),
			new BeeItem(Identifier.of("bees","ender"),new Item.Settings()));
	public static final BeeItem DESERT_BEE = Registry.register(Registries.ITEM, new Identifier("bees:desert"),
			new BeeItem(Identifier.of("bees","desert"),new Item.Settings()));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		BeeTypeRegistry.initializeDynamicRegistries();

		ServerLifecycleEvents.SERVER_STARTED.register(server->{
			World wd = server.getWorld(World.OVERWORLD);
			if (wd != null) {
				System.out.println(FOREST_BEE.getType(wd));
				System.out.println(ENDER_BEE.getType(wd));
				System.out.println(DESERT_BEE.getType(wd));
			}
			server.getRegistryManager()
					.getOptional(BeeTypeRegistry.BEE_TYPE_KEY)
					.ifPresent(registry->{
						registry
								.streamEntries()
								.forEach(entry->{
									System.out.println("Registry Value: " + entry.registryKey()
											.getValue()
											.toString()
									);
								});
					});
		});

		LOGGER.info("Hello Fabric world!");
	}
}