package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution046 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backTrack(nums, 1, null, null, ret);
        return ret;
    }

    private static void backTrack(int[] nums, int idx, Set<Integer> visited, List<Integer> singleRet, List<List<Integer>> ret) {
        if (idx >= nums.length) {
            ret.add(singleRet);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (idx == 1) {
                singleRet = new ArrayList<>();
                visited = new HashSet<>();
            }
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                singleRet.add(nums[i]);
                backTrack(nums, idx + 1, visited, singleRet, ret);
                visited.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
