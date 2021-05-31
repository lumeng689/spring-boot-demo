package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/28
 **/
public class Solution258 {

    public static int addDigits(int num) {

        if (num < 10) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return addDigits(sum);
    }

    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits2(38));
    }
}
