package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/07
 **/
public class Offer681 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (root.val < p.val) {
            if (root.val > q.val) {
                return root;
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        } else {
            if (root.val < q.val) {
                return root;
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        }

    }
}
