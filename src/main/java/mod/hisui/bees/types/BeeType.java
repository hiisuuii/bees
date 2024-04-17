package mod.hisui.bees.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.recipe.Ingredient;

public class BeeType {

    public static final Codec<BeeType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("product").forGetter(BeeType::getProduct),
            BlockPredicate.CODEC.fieldOf("flower").forGetter(BeeType::getFlower)
    ).apply(instance, BeeType::new));

    private final Ingredient product;
    private final BlockPredicate flower;

    public BeeType(Ingredient product, BlockPredicate flower){
        this.product = product;
        this.flower = flower;
    }
    public BeeType(BlockPredicate flower, ItemConvertible... products){
        this(Ingredient.ofItems(products), flower);
    }

    public Ingredient getProduct(){
        return this.product;
    }

    public BlockPredicate getFlower(){
        return this.flower;
    }

}
