package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution1154 {

    public static int dayOfYear(String date) {
        int ans = 0;

        int year = Integer.valueOf(date.substring(0, 4));
        boolean isLeapYear = false;
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            isLeapYear = true;
            monthDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }

        int month = Integer.valueOf(date.substring(5, 7));
        for (int i = 0; i < month - 1; i++) {
            ans += monthDays[i];
        }

        int day = Integer.valueOf(date.substring(8, 10));
        ans += day;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2003-03-01"));
        System.out.println(dayOfYear("2004-03-01"));
    }
}
