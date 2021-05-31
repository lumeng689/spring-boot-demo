package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/29
 **/
public class Solution1074 {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {

        return 0;
    }

    public int numSubmatrixSumTarget2(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : nums) {
            pre += x;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][]{
                new int[]{0, 1, 0},
                new int[]{1, 1, 1},
                new int[]{0, 1, 0}
        }, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{
                new int[]{1, -1},
                new int[]{-1, 1}
        }, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{
                new int[]{904}
        }, 0));
    }
}
