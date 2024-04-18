package mod.hisui.bees.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.hisui.bees.registry.BeeTypeRegistry;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Optional;

public class BeeType {

    public static final Codec<BeeType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Identifier.CODEC.fieldOf("identifier").forGetter(BeeType::getIdentifier),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("product").forGetter(BeeType::getProduct),
            BlockPredicate.CODEC.fieldOf("flower").forGetter(BeeType::getFlower)
    ).apply(instance, BeeType::new));


    private final Identifier identifier;
    private final Ingredient product;
    private final BlockPredicate flower;

    public BeeType(Identifier identifier, Ingredient product, BlockPredicate flower){
        this.identifier = identifier;
        this.product = product;
        this.flower = flower;
    }
    public BeeType(Identifier identifier, BlockPredicate flower, ItemConvertible... products){
        this(identifier, Ingredient.ofItems(products), flower);
    }

    public Identifier id(){ return this.identifier; }

    private Identifier getIdentifier() {
        return this.identifier;
    }

    public Ingredient getProduct(){
        return this.product;
    }

    public BlockPredicate getFlower(){
        return this.flower;
    }

    public String toString(){
        return this.identifier.toString();
    }

    public static BeeType.Builder builder(){
        return new Builder();
    }

    static class Builder {
        private Optional<Identifier> identifier = Optional.empty();
        private Optional<Ingredient> product = Optional.empty();
        private Optional<BlockPredicate> flower = Optional.empty();

        private Builder() {
        }

        public BeeType.Builder products(ItemConvertible... products) {
            this.product = Optional.of(Ingredient.ofItems(products));
            return this;
        }

        public BeeType.Builder identifier(Identifier id) {
            this.identifier = Optional.of(id);
            return this;
        }

        public BeeType.Builder identifier(String namespace, String path) {
            this.identifier = Optional.of(new Identifier(namespace, path));
            return this;
        }

        public BeeType.Builder flower(Block... blocks) {
            this.flower = Optional.of(BlockPredicate.Builder.create().blocks(blocks).build());
            return this;
        }
        public BeeType.Builder flower(TagKey<Block> blockTagKey) {
            this.flower = Optional.of(BlockPredicate.Builder.create().tag(blockTagKey).build());
            return this;
        }
        public BeeType.Builder flower(BlockPredicate predicate) {
            this.flower = Optional.of(predicate);
            return this;
        }

        public BeeType build() {
            return new BeeType(this.identifier.orElseThrow(), this.product.orElse(Ingredient.ofItems(Items.HONEYCOMB)),
                    this.flower.orElse(BlockPredicate.Builder.create().tag(BlockTags.FLOWERS).build()));
        }
    }
}
