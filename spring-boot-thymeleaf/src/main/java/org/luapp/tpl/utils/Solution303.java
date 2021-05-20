package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/15
 **/
public class Solution303 {

    private static class NumArray {

        private int[] nums;
        private int[] sum;

//        public NumArray(int[] nums) {
//            this.nums = nums;
//            this.sum = new int[nums.length];
//
//            this.sum[0] = this.nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                this.sum[i] = this.sum[i - 1] + nums[i];
//            }
//
//            Util.printArray(this.nums);
//            Util.printArray(this.sum);
//        }

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                this.sum[i + 1] = this.sum[i] + nums[i];
            }
            Util.printArray(this.nums);
            Util.printArray(this.sum);
        }
//public int sumRange(int left, int right) {
//    return this.sum[right+1] - this.sum[left];
//}

        public int sumRange(int left, int right) {
            return this.sum[right+1] - this.sum[left];
        }
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));
    }
}
