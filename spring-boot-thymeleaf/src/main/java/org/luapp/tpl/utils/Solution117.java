package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution117 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.right != null) {
                root.right.next = root.next == null ? null : root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

    public static void main(String[] args) {

    }
}
