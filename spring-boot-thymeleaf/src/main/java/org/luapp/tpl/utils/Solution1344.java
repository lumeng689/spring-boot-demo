package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution1344 {

    public static double angleClock(int hour, int minutes) {
        double perHour = 360 / 12;
        double perMinute = 360 / 60;

        double angleH = (hour * perHour + (minutes*1.0 / 60) * perHour) % 360;
        double angleM = minutes * perMinute;

        double diff =  Math.abs(angleH-angleM);
        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(12, 45));
    }
}
