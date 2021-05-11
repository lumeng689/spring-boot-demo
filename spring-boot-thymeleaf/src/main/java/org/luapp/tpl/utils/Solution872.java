package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Solution872 {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        getLeafs(root1, stack1);
        getLeafs(root2, stack2);

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode leaf1 = stack1.pop();
            TreeNode leaf2 = stack2.pop();

            if (leaf1.val != leaf2.val) {
                return false;
            }
        }

        return true;
    }

    public static void getLeafs(TreeNode root, Deque<TreeNode> leaf) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaf.push(root);
            return;
        }

        getLeafs(root.left, leaf);
        getLeafs(root.right, leaf);
    }

    public static void main(String[] args) {


    }
}
