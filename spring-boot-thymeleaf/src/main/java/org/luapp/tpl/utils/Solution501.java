package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: 86150
 * @create: 2021/05/28
 **/
public class Solution501 {

    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    private void update(int val) {
        if (val == base) {
            ++count;
        } else {
            count = 1;
            base = val;
        }

        if (count == maxCount) {
            answer.add(base);
        }

        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    public static void main(String[] args) {

    }
}
