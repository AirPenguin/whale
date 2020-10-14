package guo.dong.yuan.air.whale.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author YuanGuodong
 * @version 1.2
 * @description gets the date string in the specified format for the specified date
 */
public class DateUtil {
    private static final int defaultAmount = 0;
    private static final String defaultTimeFormat = "yyyyMMdd";

    public static String getAppointDay() {
        return getAppointDay(defaultAmount, defaultTimeFormat);
    }

    public static String getAppointDay(int amount) {
        return getAppointDay(amount, defaultTimeFormat);
    }

    public static String getAppointDay(String timeFormat) {
        return getAppointDay(defaultAmount, timeFormat);
    }

    public static String getAppointDay(int amount, String timeFormat) {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(calendar.DATE, amount);
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        String appointDay = format.format(calendar.getTime());
        return appointDay;
    }
}
