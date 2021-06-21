package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution1684 {
    public static int countConsistentStrings(String allowed, String[] words) {
        int[] allowChars = new int[26];
        for (char c : allowed.toCharArray()) {
            allowChars[c - 'a'] = 1;
        }

        int ans = 0;

        for (String w : words) {
            boolean allSuccess = true;
            for (char c : w.toCharArray()) {
                if (allowChars[c - 'a'] == 0) {
                    allSuccess = false;
                    break;
                }
            }

            if (allSuccess) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}
