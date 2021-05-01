package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution318 {
    public static int maxProduct(String[] words) {

        Map<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int mask = 0, size = word.length();

            for (int i = 0; i < size; i++) {
                mask |= 1 << word.charAt(i) - 'a';
            }

            if (hash.get(mask) != null) {
                hash.put(mask, Math.max(hash.get(mask), size));
            } else {
                hash.put(mask, size);
            }

            for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if ((mask & key) == 0) {
                    ans = Math.max(ans, value * size);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
//        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
//        System.out.println(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
