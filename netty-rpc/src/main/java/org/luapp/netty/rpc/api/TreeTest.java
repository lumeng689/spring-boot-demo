package org.luapp.netty.rpc.api;

/**
 * @author: 86150
 * @create: 2021/04/25
 **/
public class TreeTest {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 查找树中是否存在值为val的节点
     *
     * @param node
     * @param val
     * @return
     */
    public static boolean hasNode(Node node, int val) {
        if (node == null) {
            return false;
        }

        if (node.value == val) {
            return true;
        }

        if (node.value > val) {
            return hasNode(node.left, val);
        } else {
            return hasNode(node.right, val);
        }
//        return hasNode(node.left, val) || hasNode(node.right, val);
    }

    /**
     * 查找最近的父节点
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static Node findNearParent(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        // 两个值，只有1个左或者右的时候，肯定是没有公共父节点了
//        if (root.left == null || root.right == null) {
//            return null;
//        }

        // 1  root.value < a &&root.value < b    root.value < a  root.value < b
        if (root.value < a && root.value < b) {
            return findNearParent(root.right, a, b);
        }

        // 2 root.value > a &&root.value > b
        if (root.value > a && root.value > b) {
            return findNearParent(root.left, a, b);
        }

        if (root.value == a) {
            if (hasNode(root, b)) {
                return root;
            } else {
                return null;
            }
        }

        if (root.value == b) {
            if (hasNode(root, a)) {
                return root;
            } else {
                return null;
            }
        }

        // root.value 是在a和b之间
        if (a < b) {
            if (hasNode(root.left, a) && hasNode(root.right, b)) {
                return root;
            }
        } else {
            if (hasNode(root.left, b) && hasNode(root.right, a)) {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("111");
    }
}
