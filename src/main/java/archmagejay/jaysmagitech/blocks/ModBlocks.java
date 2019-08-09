package archmagejay.jaysmagitech.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    @GameRegistry.ObjectHolder("jaysmagitech:testblock")
    public static TestBlock TESTBLOCK;

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        TESTBLOCK.initModel();
    }
}
