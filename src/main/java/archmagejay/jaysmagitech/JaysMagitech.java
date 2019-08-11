package archmagejay.jaysmagitech;

import archmagejay.jaysmagitech.blocks.ModBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JaysMagitech.MODID, name = JaysMagitech.NAME, version = JaysMagitech.VERSION, useMetadata = true)
public class JaysMagitech
{
    public static final String MODID = "jaysmagitech";
    @SuppressWarnings("WeakerAccess")
    public static final String NAME = "Jays Magitech";
    @SuppressWarnings("WeakerAccess")
    public static final String VERSION = "1.0";

    static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Registry for Pedestal is: {}", ModBlocks.PEDESTAL.getRegistryName());
    }
}
