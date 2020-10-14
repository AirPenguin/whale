package guo.dong.yuan.air.whale.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author YuanGuodong
 * @version 1.1
 * @description close the instance that implements close,like db connection instance,IO buffer instance
 */
public class ResourceCloseUtil {
    public static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    if (closeable != null)
                        closeable.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    LoggerUtil.logger.warn("close Resource Excepition");
                }
            }
        }
    }
}
