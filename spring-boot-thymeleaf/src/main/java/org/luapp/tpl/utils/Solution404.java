package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/19
 **/
public class Solution404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<TreeNode> allNodes = new LinkedList<>();
        allNodes.offer(root);

        while (!allNodes.isEmpty()) {
            TreeNode node = allNodes.poll();

            if (node.left != null) {
                allNodes.offer(node.left);
                if (node.left == null && node.right == null) {
                    ans += node.left.val;
                }
            }

            if (node.right != null) {
                allNodes.offer(node.right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
