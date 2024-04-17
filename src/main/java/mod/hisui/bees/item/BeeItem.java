package mod.hisui.bees.item;

import mod.hisui.bees.types.BeeType;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;

public class BeeItem extends Item {
    private final Identifier beeType;

    public BeeItem(Identifier type, Item.Settings settings) {
        super(settings);
        this.beeType = type;
    }

    public Identifier getType() {
        return beeType;
    }
}
