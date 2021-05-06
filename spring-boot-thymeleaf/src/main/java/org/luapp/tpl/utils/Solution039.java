package org.luapp.tpl.utils;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution039 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length <= 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        backTrack(candidates, target, 0, path, res);

        return res;
    }

    private static void backTrack(int[] candidates, int target, int beginIdx, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = beginIdx; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backTrack(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Util.printNestList(combinationSum(new int[]{
                2, 3, 6, 7
        }, 7));
        Util.printNestList(combinationSum(new int[]{
                2, 3, 5
        }, 8));
    }
}
