package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution412 {

    public static List<String> fizzBuzz(int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else {
                ans.add("" + i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
}
