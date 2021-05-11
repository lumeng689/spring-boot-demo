package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/05/06
 **/
public class Offer068 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> list1 = new ArrayDeque<>();
        Deque<TreeNode> list2 = new ArrayDeque<>();

        getNodePath(root, p, list1);
        getNodePath(root, q, list2);

        TreeNode last = null;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.peek() == list2.peek()) {
                last = list1.pop();
                list2.pop();
            }
        }

        return last;
    }

    private static boolean getNodePath(TreeNode root, TreeNode node, Deque<TreeNode> path) {
        if (root == node) {
            return true;
        }

        if (root == null) {
            return false;
        }

        path.push(root);

        boolean found = getNodePath(root.left, node, path) || getNodePath(root.right, node, path);

        if (!found) {
            path.pop();
        }

        return found;
    }

    private TreeNode ans;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root, p, q);
        return ans;
    }

    private boolean dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean lson = dfs2(root.left, p, q);
        boolean rson = dfs2(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        dfs3(root, parentMap);
        Set<TreeNode> visited = new HashSet<>();

        while(p != null) {
            visited.add(p);
            p = parentMap.get(p.val);
        }

        while( q!= null) {
            if (visited.contains(q)) {
                return q;
            }

            q = parentMap.get(q.val);
        }

        return null;
    }

    public void dfs3(TreeNode root, Map<Integer, TreeNode> parentMap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs3(root.left, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs3(root.right, parentMap);
        }
    }

    public static void main(String[] args) {

    }
}
