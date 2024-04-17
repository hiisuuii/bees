package mod.hisui.bees.item;

import mod.hisui.bees.registry.BeeTypeRegistry;
import mod.hisui.bees.types.BeeType;
import mod.hisui.bees.types.BeeTypeDefinitions;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BeeItem extends Item {
    private final Identifier beeType;

    public BeeItem(Identifier type, Item.Settings settings) {
        super(settings);
        this.beeType = type;
    }

    public BeeType getType(World world) {
        return world.getRegistryManager().get(BeeTypeRegistry.BEE_TYPE_KEY)
                .getOrEmpty(this.beeType).orElse(BeeTypeDefinitions.FOREST);
    }
}
