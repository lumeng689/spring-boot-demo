package org.luapp.tpl.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution1360 {

    public static int daysBetweenDates(String date1, String date2) {
        int days1From1971 = daysFrom1971(date1);
        System.out.println("custome method1:" + date1 + ":" + days1From1971);
        int days2From1971 = daysFrom1971(date2);
        System.out.println("custome method2:" + date2 + ":" + days2From1971);

        getDays(date1, date2);

        return Math.abs(days1From1971 - days2From1971);
    }

    private static int daysFrom1971(String dateStr) {
        String[] dateArray = dateStr.split("-");
        int year = Integer.valueOf(dateArray[0]);
        int month = Integer.valueOf(dateArray[1]);
        int day = Integer.valueOf(dateArray[2]);

//        System.out.printf("year:%d,month:%d,day:%d \n", year, month, day);

        // 1971-1-1

        int diffDays = day - 1;
        int diffYearDays = (year - 1971) * 365;

        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                diffYearDays += 1;
            }
        }

        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diffMonthDays = 0;
        for (int i = 1; i < month; i++) {
            diffMonthDays += monthDays[i - 1];
        }

        if (isLeapYear(year) && month > 2) {
            diffMonthDays += 1;
        }

        return diffDays + diffMonthDays + diffYearDays;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void getDays(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        LocalDate d3 = LocalDate.parse("1971-01-01");


        System.out.println("lib calculate1:" + date1 + ":" + Math.abs((int) ChronoUnit.DAYS.between(d1, d3)));
        System.out.println("lib calculate2:" + date2 + ":" + Math.abs((int) ChronoUnit.DAYS.between(d2, d3)));
    }

    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
//        System.out.println(daysBetweenDates("1971-01-01", "1971-03-01"));
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println(daysBetweenDates("2074-09-12", "1983-01-08"));
    }
}
