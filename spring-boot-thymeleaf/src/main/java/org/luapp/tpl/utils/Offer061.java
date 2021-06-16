package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Offer061 {

    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                // 跳过大小王
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            // 若有重复，提前返回 false
            if (repeat.contains(num)) {
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return max - min < 5;
    }

    public static boolean isStraight2(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            // 统计大小王数量
            if (nums[i] == 0) {
                joker++;
            }
            // 若有重复，提前返回 false
            else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(isStraight(new int[]{13, 1, 11, 11, 4}));
        System.out.println(isStraight(new int[]{0, 12, 11, 11, 0}));
    }
}
