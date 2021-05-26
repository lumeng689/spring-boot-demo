package org.luapp.tpl.utils;

import java.util.*;

/**
 * @author: 86150
 * @create: 2021/05/20
 **/
public class Solution692 {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();

        for (String s : words) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        List<String> ans = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            ans.add(entry.getKey());
        }

        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return count.get(s2).equals(count.get(s1)) ? s2.compareTo(s1) : count.get(s2) - count.get(s1);
            }
        });

        return ans.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
