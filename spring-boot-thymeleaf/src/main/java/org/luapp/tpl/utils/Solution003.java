package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/04/28
 **/
public class Solution003 {


    public static  int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() <= 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if (s == null || s.length() <= 0) {
            return 0;
        }

        Set<Character> occ = new HashSet<>();

        int n = s.length();
        int rk = -1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }

            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring2("tmmzuxt"));
    }
}
