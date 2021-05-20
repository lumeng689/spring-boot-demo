package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/14
 **/
public class Solution312 {

    static int ans;

    public static int maxCoins(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, visited, 0, path);
        return ans;
    }

    private static void backtrack(int[] nums, boolean[] visited, int level, Deque<Integer> path) {

        if (level == nums.length) {
            int sum = 0;

            for (int v : path) {
                sum += v;
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int left = 1;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    left = nums[i - 1];
                }

                int right = 1;
                if (i + 1 < nums.length - 1 && !visited[i + 1]) {
                    right = nums[i + 1];
                }

                int val = left * nums[i] * right;
                path.addLast(val);
                backtrack(nums, visited, level + 1, path);
                path.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(maxCoins(new int[]{1, 5}));
    }
}
