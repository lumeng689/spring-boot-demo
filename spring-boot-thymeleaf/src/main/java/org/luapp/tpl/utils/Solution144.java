package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/23
 **/
public class Solution144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        return ans;
    }

    private static void preorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
