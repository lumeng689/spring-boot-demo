package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer007 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0) {
            return null;
        }

        TreeNode root = buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);

        return root;
    }

    private static TreeNode buildTree(int[] preorder, int preStartIdx, int preEndIdx, int[] inorder, int inStartIdx, int inEndIdx) {

        if (preStartIdx >= preEndIdx) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStartIdx]);
        int idx = 0;
        for (int i = inStartIdx; i < inEndIdx; i++) {
            if (inorder[i] == preorder[preStartIdx]) {
                idx = i;
                break;
            }
        }
        node.left = buildTree(preorder, preStartIdx + 1, preStartIdx + 1 + idx - inStartIdx, inorder, inStartIdx, idx);
        node.right = buildTree(preorder, preStartIdx + 1 + idx - inStartIdx, preEndIdx, inorder, idx + 1, inEndIdx);
        return node;
    }

    public static void main(String[] args) {
        Util.printTree(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
