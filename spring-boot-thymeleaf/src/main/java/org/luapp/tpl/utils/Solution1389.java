package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/16
 **/
public class Solution1389 {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for (int i =0;i < nums.length;i++) {
            insertArray(target, index[i], nums[i]);
        }

        return target;
    }

    private static void insertArray(int[] target, int index, int num) {
        for(int i =target.length-1;i > index;i--) {
            target[i] = target[i-1];
        }

        target[index] = num;
    }

    public static void main(String[] args) {
        Util.printArray(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}));
        Util.printArray(createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0}));
        Util.printArray(createTargetArray(new int[]{1}, new int[]{0}));
    }
}
