package mod.hisui.bees.types;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.registry.tag.BlockTags;

public class BeeTypeDefinitions {
    public static final BeeType FOREST = new BeeType(
            BlockPredicate.Builder.create().tag(BlockTags.FLOWERS).build(), Items.DIAMOND);
    public static final BeeType ENDER = new BeeType(
            BlockPredicate.Builder.create().blocks(Blocks.DRAGON_EGG).build(), Items.ENDER_PEARL);
}
