package archmagejay.jaysmagitech.proxys;

import archmagejay.jaysmagitech.JaysMagitech;
import archmagejay.jaysmagitech.blocks.ModBlocks;
import archmagejay.jaysmagitech.blocks.TestBlock;
import archmagejay.jaysmagitech.blocks.tiles.TestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new TestBlock());
        GameRegistry.registerTileEntity(TestTileEntity.class, new ResourceLocation(JaysMagitech.MODID + ":test_tile_entity"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.TESTBLOCK).setRegistryName(ModBlocks.TESTBLOCK.getRegistryName()));
    }
}
