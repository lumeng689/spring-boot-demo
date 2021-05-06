package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution047 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(nums, 0, visited, path, res);

        return res;
    }

    private static void backtrack(int[] nums, int idx, boolean[] visited, Deque<Integer> path, List<List<Integer>> res) {

        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            path.addLast(nums[i]);
            visited[i] = true;
            backtrack(nums, idx + 1, visited, path, res);
            visited[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Util.printNestList(permuteUnique(new int[]{1, 1, 2}));
        Util.printNestList(permuteUnique(new int[]{1, 2, 3}));
    }
}
