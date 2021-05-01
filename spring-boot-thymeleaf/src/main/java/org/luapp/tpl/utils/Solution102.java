package org.luapp.tpl.utils;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/04/29
 **/
public class Solution102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }

        levelTraverse(root, 0, result);

        return result;
    }

    private static void levelTraverse(TreeNode node, int i, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() < i + 1) {
            result.add(new ArrayList<>());
        }

        List<Integer> res = result.get(i);
        if (res == null) {
            res = new ArrayList<>();
            result.add(res);
        }

        res.add(node.val);

        levelTraverse(node.left, i + 1, result);
        levelTraverse(node.right, i + 1, result);
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }


        Queue<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();

            for (int i =0;i < currentLevelSize;i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                level.add(node.val);
            }

            result.add(level);
        }

        return result;
    }

    private static void test1() {

        TreeNode node20 = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null));
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, node9, node20);

        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
    }

    public static void main(String[] args) {

        test1();

    }

}
