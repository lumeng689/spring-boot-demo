package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/05/24
 **/
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeft = true;

        while (!queue.isEmpty()) {
            int n = queue.size();

            Deque<Integer> level = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (isLeft) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            isLeft = !isLeft;
            ans.add(new ArrayList<>(level));
        }

        return ans;
    }
}
