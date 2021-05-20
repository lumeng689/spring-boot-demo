package org.luapp.tpl.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @author: 86150
 * @create: 2021/05/14
 **/
public class Solution394 {
    static int ptr;

    public static String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                List<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.add(stk.removeLast());
                }

                Collections.reverse(sub);
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);

                for (int i = 0; i < repTime; i++) {
                    t.append(o);
                }

                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    private static String getString(List<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    private static String getDigits(String s) {

        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
    }
}
