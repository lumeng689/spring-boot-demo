package org.luapp.tpl.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer0321 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<TreeNode> path = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();

            path.add(node);

            if (node.left != null) {
                nodeQueue.offer(node.left);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
        }

        int[] ans = new int[path.size()];
        int i = 0;
        for (TreeNode node : path) {
            ans[i++] = node.val;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
