package guo.dong.yuan.air.whale.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author YuanGuodong
 * @version 1.0
 * @description profile resolution
 */
public class PropertiesUtil {
    /**
     * @param path
     * @return
     */
    public static Properties getProperties(String path) {
        InputStream in = null;
        Properties prop = new Properties();
        try {
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
            prop.load(in);
        } catch (IOException e) {
            LoggerUtil.logger.error("getProperties",e);
            System.exit(1);
        } finally {
            ResourceCloseUtil.close(in);
        }
        return prop;
    }
}
