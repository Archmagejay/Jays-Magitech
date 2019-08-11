package archmagejay.jaysmagitech.proxys;

import archmagejay.jaysmagitech.Config;
import archmagejay.jaysmagitech.JaysMagitech;
import archmagejay.jaysmagitech.blocks.ModBlocks;
import archmagejay.jaysmagitech.blocks.PedestalBlock;
import archmagejay.jaysmagitech.blocks.TestBlock;
import archmagejay.jaysmagitech.blocks.tiles.PedestalTileEntity;
import archmagejay.jaysmagitech.blocks.tiles.TestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "jaysmagitech.cfg"));
        Config.readConfig();
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new TestBlock());
        GameRegistry.registerTileEntity(TestTileEntity.class, new ResourceLocation(JaysMagitech.MODID + ":test_tile_entity"));

        event.getRegistry().register(new PedestalBlock());
        GameRegistry.registerTileEntity(PedestalTileEntity.class, new ResourceLocation(JaysMagitech.MODID + ":pedestal"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.TESTBLOCK).setRegistryName(ModBlocks.TESTBLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.PEDESTAL).setRegistryName(ModBlocks.PEDESTAL.getRegistryName()));
    }
}
