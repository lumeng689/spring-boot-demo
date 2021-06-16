package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution1805 {

    public static int numDifferentIntegers(String word) {
        if (word == null || word.length() <= 0) {
            return 0;
        }

        word = word + "a";
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    while(sb.charAt(0) == '0' && sb.length() > 1) {
                        sb.deleteCharAt(0);
                    }
                    ans.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }

        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("0a0"));
    }
}
