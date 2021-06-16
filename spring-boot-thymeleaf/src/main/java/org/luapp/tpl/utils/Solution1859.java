package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution1859 {

    public static String sortSentence(String s) {

        String[] array = s.split(" ");
        Map<Integer, String> aa = new HashMap<>();

        for (String ss : array) {
            int idx = 0;
            int j = ss.length() - 1;
            char c = ss.charAt(j);
            int m = 1;
            while (c >= '0' && c <= '9') {
                idx += m * (c - '0');
                m = m * 10;
                j--;
                c = ss.charAt(j);
            }

            aa.put(idx, ss.substring(0, j + 1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < aa.size() + 1; i++) {
            sb.append(aa.get(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }
}
