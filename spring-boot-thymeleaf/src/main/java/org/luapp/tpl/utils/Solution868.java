package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/05
 **/
public class Solution868 {
    public static int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) > 0) {
                if (last >= 0) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(1));
    }
}
