package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution287 {

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{1, 1}));
        System.out.println(findDuplicate(new int[]{1, 1, 2}));
    }
}
