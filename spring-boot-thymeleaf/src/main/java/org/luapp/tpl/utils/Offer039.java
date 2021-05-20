package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer039 {

    /**
     * 方法1 排序
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 方法2 map
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int count = counts.getOrDefault(nums[i], 0) + 1;
            //如果某个数字出现的个数已经超过数组的一半，自己返回
            if (count > length / 2) {
                return nums[i];
            }
            counts.put(nums[i], count);
        }
        return -1;
    }

    /**
     * 方法3 位运算
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        int major = 0;
        int length = nums.length;
        //在java中int类型是32位，我们遍历每一位
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            //bitCounts表示所有数字在当前位置1的个数。比如当i=0
            //的时候，我们可以认为他表示的是所有数字在二进制位
            //中最右边1的总数。
            int bitCounts = 0;
            for (int j = 0; j < length; j++) {
                //判断数字nums[j]的第i（i从0开始）个位置是否为1，
                //如果是1，bitCounts就加1
                if ((nums[j] & mask) != 0) {
                    bitCounts++;
                }
                //如果bitCounts大于数组的一半，那么这个众数在
                //这个位置肯定是1，然后通过 major |= mask运算
                //把这个位置变为1，后面不需要再判断了，直接终止
                //内层循环
                if (bitCounts > length / 2) {
                    major |= mask;
                    break;
                }
            }
        }
        return major;
    }

    /**
     * 方法4 摩尔投票法
     *
     * @param nums
     * @return
     */
    public static int majorityElement4(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                //前面都消完了，在重新赋值
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                //自己人，count就加1
                count++;
            } else {
                //不是自己人就同归于尽，消掉一个
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
    }
}
