package org.luapp.tpl.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/04/18
 **/
public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 3) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        dfs(s, -1, 1, new ArrayList<String>(), result);

        return result;
    }

    public static void dfs(String str, int index, int level, List res, List result) {
        if (level == 5 || index >= str.length() - 1) {
            if (level == 5 && index == str.length() - 1) {

                result.add(StringUtils.join(res, "."));
            }
            return;
        }

        for (int i = 1; i < 4; i++) {

            int endIndex = index + i + 1 > str.length() ? str.length() : index + i + 1;

            String sub = str.substring(index + 1, endIndex);

            if (("0".equals(sub) || !sub.startsWith("0")) && Integer.valueOf(sub) < 256) {
                res.add(sub);
                dfs(str, index + i, level + 1, res, result);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void printList(List<String> list) {
        System.out.print("[");
        if (list != null) {
            for (String s : list) {
                System.out.print(s + ", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }

    public static void main(String[] args) {
//        String s1 = "25525511135";
//        printList(restoreIpAddresses(s1));

//        String s2 = "0000";
//        printList(restoreIpAddresses(s2));
        String s3 = "1111";
        printList(restoreIpAddresses(s3));

    }
}
