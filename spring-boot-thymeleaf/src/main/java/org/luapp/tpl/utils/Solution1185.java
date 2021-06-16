package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution1185 {

    public static String dayOfTheWeek(int day, int month, int year) {
        String res[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month == 1 || month == 2) {
            month = month + 12;
            year--;
        }
        int index = 0;
        //基姆拉尔森计算公式
        index = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return res[index];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
    }
}
