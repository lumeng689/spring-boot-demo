package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/25
 **/
public class Solution1002 {


    public static List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String s : words) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Util.printList(commonChars(new String[]{"bella","label","roller"}));
        Util.printList(commonChars(new String[]{"cool","lock","cook"}));
    }
}
