package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution929 {

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            uniqueEmails.add(formatEmail(emails[i]));
        }

        return uniqueEmails.size();
    }

    private static String formatEmail(String email) {

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        char c;
        boolean findPlus = false;
        while ((c = email.charAt(idx)) != '@') {

            if (findPlus) {
                idx++;
            } else {
                if (c == '+') {
                    findPlus = true;
                } else if (c == '.') {

                } else {
                    sb.append(c);
                }
                idx++;
            }
        }

        sb.append(email.substring(idx));

        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
