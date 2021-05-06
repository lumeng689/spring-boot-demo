package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution046 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, i, first);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            } else {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, nums.length, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute2(new int[]{1, 2, 3}));
    }
}
