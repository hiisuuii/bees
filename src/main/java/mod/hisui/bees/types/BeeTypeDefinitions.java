package mod.hisui.bees.types;

import net.minecraft.block.Blocks;

public class BeeTypeDefinitions {
    public static final BeeType FOREST = BeeType.builder().identifier("bees","forest").build();
    public static final BeeType PLAINS = BeeType.builder().identifier("bees","plains").build();
    public static final BeeType DESERT = BeeType.builder().identifier("bees","desert").build();
    public static final BeeType MOIST = BeeType.builder().identifier("bees","moist").build();
    public static final BeeType NETHER = BeeType.builder().identifier("bees","nether").flower(Blocks.NETHER_WART).build();
}
