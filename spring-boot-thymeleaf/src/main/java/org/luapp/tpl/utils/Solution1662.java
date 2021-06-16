package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/12
 **/
public class Solution1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null || word1.length == 0) {
            return false;
        }

        StringBuilder sb1 = new StringBuilder();
        for(String s: word1) {
            sb1.append(s);
        }

        StringBuilder sb2 = new StringBuilder();
        for(String s: word2) {
            sb2.append(s);
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {

    }
}
