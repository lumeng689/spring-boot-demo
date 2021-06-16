package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Offer0322 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelNode = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                levelNode.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(levelNode);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
