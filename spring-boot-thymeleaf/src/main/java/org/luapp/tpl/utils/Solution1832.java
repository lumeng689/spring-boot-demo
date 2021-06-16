package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution1832 {

    public static boolean checkIfPangram(String sentence) {
        if (sentence == null || sentence.length() < 26) {
            return false;
        }

        boolean[] visited = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            visited[c - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
