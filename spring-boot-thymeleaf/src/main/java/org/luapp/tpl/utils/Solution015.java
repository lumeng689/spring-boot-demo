package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n-1;
            int target = -nums[first];

            for (int second = first+1;second < n;second++) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }

                while(second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Util.printNestList(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Util.printNestList(threeSum(new int[]{}));
        Util.printNestList(threeSum(new int[]{0}));
    }
}
