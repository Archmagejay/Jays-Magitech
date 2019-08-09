package archmagejay.jaysmagitech;

import archmagejay.jaysmagitech.blocks.ModBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JaysMagitech.MODID, name = JaysMagitech.NAME, version = JaysMagitech.VERSION)
public class JaysMagitech
{
    public static final String MODID = "jaysmagitech";
    public static final String NAME = "Jays Magitech";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Registry for Test block is: {}", ModBlocks.TESTBLOCK.getRegistryName());
    }
}
