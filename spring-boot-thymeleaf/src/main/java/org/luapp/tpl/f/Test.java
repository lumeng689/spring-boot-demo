package org.luapp.tpl.f;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Test {
    public static String findCommonSubString(String a, String b) {

        if (a == null || a == "" || b == null || b == "") {
            return "";
        }
        // 让a 为max的
        if (b.length() > a.length()) {
            String c = a;
            a = b;
            b =c;
        }

        String substr = "";
        // b 是短串， A是长串
        for (int i =1;i < b.length();i++) {
            for (int j =0;j < i;j++) {
                String p = b.substring(j, i+1);
                // 说明p在a中出现了
                if (a.indexOf(p) >=0) {
                    if (substr.length() < p.length()) {
                        substr = p;
                    }
                }
            }
        }

        return substr;
    }

    public static void main(String[] args) {
        System.out.println(findCommonSubString("12ddd", "12hhh"));
        System.out.println(findCommonSubString("12ddd", "12hhh12ddd"));
    }
}
