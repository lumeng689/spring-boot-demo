package org.luapp.tpl.utils;

import org.mvel2.util.Make;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/14
 **/
public class Solution012 {

    public static String intToRoman(int num) {
//        Map<Integer, String> labels = new HashMap<>();
//        labels.put(1, "I");
//        labels.put(4, "IV");
//        labels.put(5, "V");
//        labels.put(9, "IX");
//        labels.put(10, "X");
//        labels.put(40, "XL");
//        labels.put(50, "L");
//        labels.put(90, "XC");
//        labels.put(100, "C");
//        labels.put(400, "CD");
//        labels.put(500, "D");
//        labels.put(900, "CM");
//        labels.put(1000, "M");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];

            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }

            if (num == 0) {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
