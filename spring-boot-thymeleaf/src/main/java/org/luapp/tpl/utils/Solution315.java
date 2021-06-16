package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Solution315 {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();



        Deque<Integer> stack = new ArrayDeque<>();

        int i = nums.length - 1;
        while (i >= 0) {

        }

        return ans;
    }

    public static void main(String[] args) {
        Util.printIntList(countSmaller(new int[]{5, 2, 6, 1}));
    }
}
