package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution434 {

    public static int countSegments(String s) {
        String[] arrays = s.split(" ");

        int ans = 0;
        for (String s1 : arrays) {
            if (!"".equals(s1)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello,   my   name is John"));
    }
}
