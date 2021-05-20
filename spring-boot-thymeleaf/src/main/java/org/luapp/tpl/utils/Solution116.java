package org.luapp.tpl.utils;

import com.fasterxml.jackson.databind.util.LinkedNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution116 {

    public static Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }

        return root;
    }

    public static Node connect2(Node root) {
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
