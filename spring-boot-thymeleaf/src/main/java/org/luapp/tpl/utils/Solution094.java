package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution094 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();

        inorder(root, path);

        return path;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    private static void inorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        inorder(root.left, path);
        path.add(root.val);
        inorder(root.right, path);
    }

    public static void main(String[] args) {
        TreeNode root = Util.buildFromArray(new Integer[]{1, null, 2, null, null, 3});

        Util.printIntList(inorderTraversal(root));
        Util.printIntList(inorderTraversal2(root));

        System.out.println("=================");
    }
}
