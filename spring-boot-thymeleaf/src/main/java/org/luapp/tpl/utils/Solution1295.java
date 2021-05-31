package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/27
 **/
public class Solution1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isOdd(nums[i])) {
                count++;
            }
        }

        return count;
    }

    private boolean isOdd(int num) {

        int count = 0;

        while (num > 0) {
            count++;
            num /= 10;
        }

        return count % 2 == 0;
    }
}
