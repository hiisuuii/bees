package mod.hisui.bees.data;

import mod.hisui.bees.registry.BeeTypeRegistry;
import mod.hisui.bees.types.BeeType;
import mod.hisui.bees.types.BeeTypeDefinitions;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BeeTypeGenerator extends FabricCodecDataProvider<BeeType> {

    public BeeTypeGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(dataOutput, registriesFuture, DataOutput.OutputType.DATA_PACK,
                BeeTypeRegistry.BEE_TYPE_KEY.getValue().toString().replace(":","/"), BeeType.CODEC);
    }

    public String getName(){
        return "BeeTypeGenerator";
    }

    @Override
    protected void configure(BiConsumer<Identifier, BeeType> provider, RegistryWrapper.WrapperLookup lookup) {
        provider.accept(new Identifier("bees:forest"), BeeTypeDefinitions.FOREST);
    }
}
