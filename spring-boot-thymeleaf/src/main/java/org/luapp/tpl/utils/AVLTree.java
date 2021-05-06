package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2020/04/04
 **/
public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    public static class AVLTreeNode<T extends Comparable<T>> {
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    public AVLTree() {
        mRoot = null;
    }

    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }

        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            inOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }

        return x;
    }

    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while (tree.left != null) {
            tree = tree.left;
        }

        return tree;
    }

    public T minimum() {
        AVLTreeNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while (tree.right != null) {
            tree = tree.right;
        }

        return tree;
    }

    public T maximum() {
        AVLTreeNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }



//    // 插入节点
//    public void insert(AVLNode root, int data) {
//        // data小于root的data，则在左子树插入
//        if (data < root.data) {
//            if (root.left != null) {
//                insert(root.left, data);
//            } else {
//                root.left = new AVLNode(data);
//                root.left.parent = root;
//            }
//        } else {
//            // data大于root的data， 在右子树插入
//            if (root.right != null) {
//                insert(root.right, data);
//            } else {
//                root.right = new AVLNode(data);
//                root.right.parent = root;
//            }
//        }
//
//        root.balance = calcBalance(root);
//    }
//
//    // 计算平衡
//    public int calcBalance(AVLNode p) {
//
//        int leftDepth = 0;
//        int rightDepth = 0;
//
//        if (p.left != null) {
//            leftDepth = p.left.depth;
//        }
//
//        if (p.right != null) {
//            rightDepth = p.right.depth;
//        }
//
//        return leftDepth - rightDepth;
//    }
//
//    public static void main(String[] args) {
//
//    }
}
