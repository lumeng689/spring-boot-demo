package org.luapp.tpl.utils;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/17
 **/
public class Solution993 {

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null || root.left == null || root.right == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            if (queue.size() <= 1) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x || node.right.val == x) && (node.left.val == y || node.right.val == y)) {
                        return false;
                    }
                }
            } else {
                int n = queue.size();

                boolean foundX = false;
                boolean foundY = false;

                while (n-- > 0) {
                    TreeNode node = queue.poll();

                    if (node.val == x) {
                        foundX = true;
                    } else if (node.val == y) {
                        foundY = true;
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    if (node.left != null && node.right != null) {
                        if ((node.left.val == x || node.right.val == x) && (node.left.val == y || node.right.val == y)) {
                            return false;
                        }
                    }
                }

                if (foundX && foundY) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
