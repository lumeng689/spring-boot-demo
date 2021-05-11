package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <3) {
            return ans;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, 0, 0,visited,  ans, path);
        return ans;
    }

    private static void backtrack(int[] nums, int startIdx, int remain, boolean[] visited, List<List<Integer>> ans, Deque<Integer> path) {
        if (startIdx == nums.length || path.size() == 3) {
            if (remain == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);
                backtrack(nums, startIdx + 1, remain - nums[i],visited, ans, path);
                path.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Util.printNestList(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Util.printNestList(threeSum(new int[]{}));
        Util.printNestList(threeSum(new int[]{0}));
    }
}
