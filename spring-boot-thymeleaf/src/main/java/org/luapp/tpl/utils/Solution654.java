package org.luapp.tpl.utils;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/06
 **/
public class Solution654 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curNode = null;

        for (int i = 0; i < nums.length; i++) {
            curNode = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                TreeNode top = stack.pop();
                if (!stack.isEmpty() && stack.peek().val < curNode.val) {
                    stack.peek().right = top;
                } else {
                    curNode.left = top;
                }
            }

            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            curNode = stack.pop();

            if (!stack.isEmpty()) {
                stack.peek().right = curNode;
            }
        }

        return curNode;
    }

    public static void main(String[] args) {
        TreeNode r1 = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        TreeNode r2 = constructMaximumBinaryTree(new int[]{3, 2, 1});
        System.out.println("");
    }
}
