package com.musk.web.utils;


import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author
 * @date 2024/08/19
 */
public class LocalDateHelper {

    /**
     * 比较两个日期相差的天数
     * @param date1
     * @param date2
     * @return int
     */
    public static int betweenOfDay(LocalDate date1,LocalDate date2){
        return betweenOfDay(date1.atStartOfDay(),date2.atStartOfDay());
    }

    public static int betweenOfDay(LocalDateTime time1, LocalDateTime time2){
        long between = LocalDateTimeUtil.between(time1, time2, ChronoUnit.DAYS);
        return (int) Math.abs(between);
    }


    public static LocalDate beforeDay(LocalDate localDate ,int day){
        return beforeDay(localDate.atStartOfDay(),day);
    }


    public static LocalDate beforeDay(LocalDateTime dateTime ,int day){
        return LocalDateTimeUtil.offset(dateTime,day,ChronoUnit.DAYS).toLocalDate();
    }
}
