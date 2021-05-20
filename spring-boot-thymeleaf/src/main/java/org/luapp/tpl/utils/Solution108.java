package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/19
 **/
public class Solution108 {

    public static TreeNode sortedArrayToBST2(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


    public static TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        TreeNode root = buildTree1(nums, 0, nums.length - 1);
        return root;
    }

    private static TreeNode buildTree1(int[] nums, int low, int high) {

        if (low > high || low < 0 || high >= nums.length) {
            return null;
        }

        int mid = (low + high + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree1(nums, low, mid - 1);
        node.right = buildTree1(nums, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        sortedArrayToBST1(new int[]{-10, -3, 0, 5, 9});
//        sortedArrayToBST2(new int[]{-10, -3, 0, 5, 9});
    }
}
