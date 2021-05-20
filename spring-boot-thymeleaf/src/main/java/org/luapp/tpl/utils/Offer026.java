package org.luapp.tpl.utils;

import lombok.val;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer026 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public static void main(String[] args) {

    }
}
