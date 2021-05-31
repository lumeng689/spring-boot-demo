package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution1491 {

    public static double average(int[] salary) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < salary.length; i++) {
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
            sum += salary[i];
        }

        return (sum - min - max) * 1.0 / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println(average(new int[]{1000, 2000, 3000}));
        System.out.println(average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        System.out.println(average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }
}
