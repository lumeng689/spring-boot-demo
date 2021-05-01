package org.luapp.tpl.utils;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: 86150
 * @create: 2021/04/19
 **/
public class InOrderTraverse {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0));
        for (int i = 1; i < 20; i = i + 2) {
            int idx = Double.valueOf(Math.floor(i / 2.0)).intValue();
            TreeNode parent = list.get(idx);
            parent.left = new TreeNode(i);
            parent.right = new TreeNode(i + 1);

            list.add(parent.left);
            list.add(parent.right);
        }

        return list.get(0);
    }

    private static void PreOrderVisit(TreeNode root) {

        System.out.print(root.value + " -> ");

        if (root.left != null) {
            PreOrderVisit(root.left);
        }

        if (root.right != null) {
            PreOrderVisit(root.right);
        }

    }

    private static void PreOrderVisit2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()) {
            TreeNode s = stack.pop();
            if (s.right != null) {
                stack.push(s.right);
            }

            if (s.left != null) {
                stack.push(s.left);
            }

            System.out.print(s.value + " -> ");
        }
    }

    private static void InOrderVisit(TreeNode root) {

        if (root.left != null) {
            InOrderVisit(root.left);
        }

        System.out.print(root.value + " -> ");

        if (root.right != null) {
            InOrderVisit(root.right);
        }
    }

    private static void InOrderVisit2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode s = stack.pop();
            if (s.right != null) {
                stack.push(s.right);
            }

            if (s.left != null) {
                stack.push(s.left);
            }

            System.out.print(s.value + " -> ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();

        PreOrderVisit(root);
        System.out.println();
        PreOrderVisit2(root);
        System.out.println();
    }
}
