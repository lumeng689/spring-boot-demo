package org.luapp.tpl.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution1441 {

    public static List<String> buildArray(int[] target, int n) {

        List<String> res = new LinkedList<>();

        int i = 1;
        for (int num: target) {
            while (i != num) {
                res.add("push");
                res.add("pop");
                i++;
            }

            res.add("push");
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Util.printList(buildArray(new int[]{1, 3}, 3));
        Util.printList(buildArray(new int[]{1, 2, 3}, 3));
        Util.printList(buildArray(new int[]{1, 2}, 4));
        Util.printList(buildArray(new int[]{2, 3, 4}, 4));
    }
}
