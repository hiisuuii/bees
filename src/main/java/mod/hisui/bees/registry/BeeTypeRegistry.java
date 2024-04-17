package mod.hisui.bees.registry;

import mod.hisui.bees.types.BeeType;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BeeTypeRegistry {
    public static final RegistryKey<Registry<BeeType>> BEE_TYPE_KEY = RegistryKey.ofRegistry(new Identifier("bees","bee_types"));

    public static void initializeDynamicRegistries(){
        DynamicRegistries.registerSynced(BEE_TYPE_KEY, BeeType.CODEC);
    }
}
