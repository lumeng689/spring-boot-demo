package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution1446 {

    public static int maxPower(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char lastChar = s.charAt(0);
        int count = 0;
        int maxCount = -1;
        for (char c : s.toCharArray()) {
            if (c == lastChar) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                lastChar = c;
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));
    }
}
