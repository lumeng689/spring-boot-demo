package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Solution075 {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }

        for (int i = ptr; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ++ptr;
            }
        }
    }

    public static void main(String[] args) {
        int[] p1 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(p1);
        Util.printArray(p1);

        int[] p2 = new int[]{2, 0, 1};
        sortColors(p2);
        Util.printArray(p2);

        int[] p3 = new int[]{0};
        sortColors(p3);
        Util.printArray(p3);

        int[] p4 = new int[]{1};
        sortColors(p4);
        Util.printArray(p4);
    }
}
