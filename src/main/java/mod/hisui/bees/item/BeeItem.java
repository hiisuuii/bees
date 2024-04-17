package mod.hisui.bees.item;

import mod.hisui.bees.types.BeeType;
import net.minecraft.item.Item;

public class BeeItem extends Item {
    private final BeeType type;

    public BeeItem(BeeType type, Item.Settings settings) {
        super(settings);
        this.type = type;
    }

    public BeeType getType() {
        return type;
    }
}
