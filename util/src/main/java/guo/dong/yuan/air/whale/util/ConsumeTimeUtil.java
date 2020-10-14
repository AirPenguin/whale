package guo.dong.yuan.air.whale.util;

/**
 * @author YuanGuodong
 * @version 1.1
 * @description output program run time
 */
public class ConsumeTimeUtil {
    private static long startTime;
    private static long endTime;
    private static long runTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void end() {
        endTime = System.currentTimeMillis();
    }

    public static String consumeTime() {
        runTime = endTime - startTime;
        return "RunTimeStatisticsUtil{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", runTime=" + runTime +
                '}';
    }
}
