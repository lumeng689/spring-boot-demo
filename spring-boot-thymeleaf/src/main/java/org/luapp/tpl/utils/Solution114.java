package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution114 {

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.push(root);

        TreeNode curNode = null;
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();

            System.out.println(node.val);

            if (node.right != null) {
                treeNodes.push(node.right);
            }

            if (node.left != null) {
                treeNodes.push(node.left);
            }

            if (curNode != null) {
                curNode.left = null;
                curNode.right = node;
            }
            curNode = node;
        }
    }

    public static void dfs(TreeNode node, Deque<TreeNode> treeNodes) {
        if (node == null) {
            return;
        }

        treeNodes.offer(node);
        if (node.left == null && node.right == null) {
            return;
        } else {
            dfs(node.left, treeNodes);
            dfs(node.right, treeNodes);
        }
    }

    public static void main(String[] args) {
        TreeNode root = Util.buildFromArray(new Integer[]{1, 2, 5, 3, 4, null, 6});

        flatten(root);
        System.out.println("===============");
    }
}
