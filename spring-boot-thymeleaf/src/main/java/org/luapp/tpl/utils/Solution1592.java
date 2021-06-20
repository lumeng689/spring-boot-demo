package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution1592 {

    public static String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        int spaceCount = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            words.add(sb.toString());
        }

        StringBuilder ans = new StringBuilder();

        if (words.size() == 1) {
            ans.append(words.get(0));
            for (int i = 0; i < spaceCount; i++) {
                ans.append(' ');
            }
        } else {
            int margin = words.size() - 1;
            int marginSpace = spaceCount / margin;
            int remain = spaceCount % margin;

            for (int i = 0; i < words.size(); i++) {
                if (i != 0) {
                    for (int j = 0; j < marginSpace; j++) {
                        ans.append(' ');
                    }
                }
                ans.append(words.get(i));
            }

            for (int i = 0; i < remain; i++) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
        System.out.println(reorderSpaces("hello   world"));
        System.out.println(reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(reorderSpaces("a"));
    }
}
