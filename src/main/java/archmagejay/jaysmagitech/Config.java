package archmagejay.jaysmagitech;

import archmagejay.jaysmagitech.proxys.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    private static final String CATEGORY_GENERAL = "general";

    public static boolean testCfg = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e) {
            JaysMagitech.logger.log(Level.ERROR, "Problem loading config file!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
        testCfg = cfg.getBoolean("testing", CATEGORY_GENERAL, testCfg, "Testing config files");
    }
}
