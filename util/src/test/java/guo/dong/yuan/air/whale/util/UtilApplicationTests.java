package guo.dong.yuan.air.whale.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@SpringBootTest
class UtilApplicationTests {

    @Test
    void contextLoads() {
    }
    public static void main(String[] args) throws Exception {
        UtilApplicationTests testDemo = new UtilApplicationTests();
        testDemo.testConsumeTimeUtil();
        testDemo.testDateUtil();
        testDemo.testLoggerUtil();
        testDemo.testPropertiesUtil();
        testDemo.testResourceCloseUtil();
    }

    /**
     * @throws InterruptedException
     * @example ConsumeTimeUtil
     */
    public void testConsumeTimeUtil() throws InterruptedException {
        ConsumeTimeUtil.start();
        Thread.sleep(1000);
        ConsumeTimeUtil.end();
        System.out.println(ConsumeTimeUtil.consumeTime());
    }

    /**
     * @example testDateUtil
     */
    public void testDateUtil() {
        String today;
        String tomorrow;
        String formatToday;
        String formatTomorrow;
        today = DateUtil.getAppointDay();
        tomorrow = DateUtil.getAppointDay(1);
        formatToday = DateUtil.getAppointDay("yyyy-MM-dd");
        formatTomorrow = DateUtil.getAppointDay(1, "yyyy-MM-dd");
        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(formatToday);
        System.out.println(formatTomorrow);
    }

    /**
     * @example testLoggerUtil
     */
    public void testLoggerUtil() {
        LoggerUtil.logger.info("info");
        LoggerUtil.logger.warn("warn");
        LoggerUtil.logger.error("error");
        try {
//          exception code
        } catch (Exception e) {
            LoggerUtil.logger.error("error",e);
        }
    }
    /**
     * @example testLoggerUtil
     */
    public void testPropertiesUtil() {
        final Properties CONFIG = PropertiesUtil.getProperties("config.properties");
        final String TESTVALUE = CONFIG.getProperty("testkey");
        System.out.println(TESTVALUE);
    }
    public void testResourceCloseUtil() throws FileNotFoundException, UnsupportedEncodingException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("config.properties"), "UTF-8"));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("log4j.properties"), "UTF-8"));
        ResourceCloseUtil.close(in1,in2);
    }
}
