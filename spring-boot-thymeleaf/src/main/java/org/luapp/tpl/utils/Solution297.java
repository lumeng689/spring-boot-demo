package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution297 {

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }

        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] treeNodes = data.split(",");
        List<String> treeNodesList = new LinkedList<String>(Arrays.asList(treeNodes));
        return rdeserialize(treeNodesList);
    }

    private TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public static void main(String[] args) {

    }
}
