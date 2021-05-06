package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/06
 **/
public class Solution1720 {

    public static int[] decode(int[] encoded, int first) {
        if (encoded == null) {
            return new int[]{first};
        }

        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i-1] ^ encoded[i-1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Util.printArray(decode(new int[]{1, 2, 3}, 1));
        Util.printArray(decode(new int[]{6, 2, 7, 3}, 4));
    }
}
