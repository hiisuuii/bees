package mod.hisui.bees;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.recipe.Ingredient;

public class BeeType {

    private Ingredient product;
    private Block flower;
    public static final Codec<BeeType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("product").forGetter(BeeType::getProduct),
            Block.CODEC.fieldOf("flower").forGetter(BeeType::getFlower)
    ).apply(instance, BeeType::new));

    public BeeType(){

    }
    public BeeType(Ingredient product, Block flower){
        this();
    }

    public Ingredient getProduct(){
        return this.product;
    }

    public Block getFlower(){
        return this.flower;
    }

}
