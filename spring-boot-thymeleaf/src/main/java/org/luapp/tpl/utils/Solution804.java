package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution804 {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> codedSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                sb.append(codes[c - 'a']);
            }
            codedSet.add(sb.toString());
        }

        return codedSet.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
