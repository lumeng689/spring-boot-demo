package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution942 {

    public static int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];

        int left = 0;
        int right = s.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'D') {
                ans[i] = right--;
            } else {
                ans[i] = left++;
            }
        }

        ans[s.length()] = right;

        return ans;
    }

    public static void main(String[] args) {
        Util.printArray(diStringMatch("IDID"));
        Util.printArray(diStringMatch("III"));
        Util.printArray(diStringMatch("DDI"));
    }
}
