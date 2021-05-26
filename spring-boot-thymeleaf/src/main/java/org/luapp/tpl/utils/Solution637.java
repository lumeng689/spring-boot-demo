package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/23
 **/
public class Solution637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(sum / n);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
