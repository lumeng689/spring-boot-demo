package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/23
 **/
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        postorder(root, ans);

        return ans;
    }

    private void postorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == prev) {
                ans.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
