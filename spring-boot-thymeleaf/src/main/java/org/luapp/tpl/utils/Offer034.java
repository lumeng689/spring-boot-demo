package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/17
 **/
public class Offer034 {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, target, path, ans);
        return ans;
    }

    private static void dfs(TreeNode root, int target, Deque<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, target, path, ans);
        dfs(root.right, target, path, ans);
        path.removeLast();
    }

    public static void main(String[] args) {
        Util.printNestList(pathSum(Util.buildFromArray(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null,null,5, 1}), 22));
    }
}
