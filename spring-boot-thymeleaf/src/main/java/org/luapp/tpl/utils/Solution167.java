package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution167 {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {

            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        Util.printArray(twoSum(new int[]{2, 7, 11, 15}, 9));
        Util.printArray(twoSum(new int[]{2, 3, 4}, 6));
        Util.printArray(twoSum(new int[]{-1, 0}, -1));
    }
}
