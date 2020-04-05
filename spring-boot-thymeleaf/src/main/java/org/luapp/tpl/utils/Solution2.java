package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2020/04/05
 **/
public class Solution2 {
    public static String replaceSpace(String s) {
        if (s.length() <= 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] aList = A.split(" ");
        String[] bList = B.split(" ");

        if (aList.length <= 0) {
            return bList;
        }

        if (bList.length <= 0) {
            return aList;
        }

        Map<String, Integer> maps = new HashMap<>();

        for (int i = 0; i < aList.length; i++) {
            maps.put(aList[i], maps.getOrDefault(aList[i], 0) + 1);
        }

        for (int i = 0; i < bList.length; i++) {
            maps.put(bList[i], maps.getOrDefault(bList[i], 0) + 1);
        }

        List<String> ans = new LinkedList<>();
        for (String word: maps.keySet()) {
            if (maps.get(word) == 1) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
