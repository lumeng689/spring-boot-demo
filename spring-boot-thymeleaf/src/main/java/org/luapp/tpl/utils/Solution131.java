package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        Deque<String> path = new ArrayDeque<>();
        backtrack(s, 0, path, res);
        return res;
    }

    private static void backtrack(String s, int startIdx, Deque<String> path, List<List<String>> res) {

        if (startIdx >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = startIdx; i < s.length(); i++) {

            if (isValid(s, startIdx, i)) {
                String str = s.substring(startIdx, i + 1);
                path.addLast(str);
            } else {
                continue;
            }

            backtrack(s, i + 1, path, res);
            path.removeLast();
        }
    }

    private static boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Util.printNestList(partition("aab"));
        Util.printNestList(partition("a"));
//
//        System.out.println(isValid("a"));
//        System.out.println(isValid("aa"));
//        System.out.println(isValid("aba"));
//        System.out.println(isValid("abab"));
    }
}
