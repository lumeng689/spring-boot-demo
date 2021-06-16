package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/06/16
 **/
public class Solution1047 {

    public static String removeDuplicates1(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    public static String removeDuplicates2(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates1("abbaca"));
        System.out.println(removeDuplicates2("abbaca"));
    }
}
