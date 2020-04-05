package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2020/04/04
 **/
public class AVLTree {

    public static class AVLNode {
        public int data;//保存节点数据
        public int depth;//保存节点深度
        public int balance;//是否平衡
        public AVLNode parent;//指向父节点
        public AVLNode left;//指向左子树
        public AVLNode right;//指向右子树

        public AVLNode(int data) {
            this.data = data;
            depth = 1;
            balance = 0;
            left = null;
            right = null;
            parent = null;
        }
    }

    // 插入节点
    public void insert(AVLNode root, int data) {
        // data小于root的data，则在左子树插入
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new AVLNode(data);
                root.left.parent = root;
            }
        } else {
            // data大于root的data， 在右子树插入
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new AVLNode(data);
                root.right.parent = root;
            }
        }

        root.balance = calcBalance(root);
    }

    // 计算平衡
    public int calcBalance(AVLNode p) {

        int leftDepth = 0;
        int rightDepth = 0;

        if (p.left != null) {
            leftDepth = p.left.depth;
        }

        if (p.right != null) {
            rightDepth = p.right.depth;
        }

        return leftDepth - rightDepth;
    }

    public static void main(String[] args) {

    }
}
