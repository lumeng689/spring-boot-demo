package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution113 {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        path.add(root.val);
        dfs(root, targetSum - root.val, path, res);
        return res;
    }

    private static void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }

            return;
        }

        if (node.left != null) {
            path.add(node.left.val);
            dfs(node.left, sum - node.left.val, path, res);
            path.removeLast();
        }

        if (node.right != null) {
            path.add(node.right.val);
            dfs(node.right, sum - node.right.val, path, res);
            path.removeLast();
        }
    }

    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(root, targetSum, path, res);
        return res;
    }

    private static void dfs2(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {

        if (node == null) {
            return;
        }

        path.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        } else {
            dfs2(node.left, sum, path, res);
            dfs2(node.right, sum, path, res);
        }

        path.removeLast();
    }

    public static void main(String[] args) {

        Util.printNestList(pathSum(Util.buildFromArray(new Integer[]{
                5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1
        }), 22));

        Util.printNestList(pathSum2(Util.buildFromArray(new Integer[]{
                5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1
        }), 22));
    }
}
