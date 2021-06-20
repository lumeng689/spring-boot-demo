package org.luapp.tpl.utils;

import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution1773 {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items == null || items.size() == 0) {
            return 0;
        }

        int ans = 0;

        int rowIdx = 0;
        if (ruleKey.equals("type")) {
            rowIdx = 0;
        } else if (ruleKey.equals("color")) {
            rowIdx = 1;
        } else {
            rowIdx = 2;
        }

        for (List<String> item : items) {
            if (item.get(rowIdx).equals(ruleValue)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countMatches(Util.buildNestListFromArray(new String[][]{
                new String[]{"phone", "blue", "pixel"},
                new String[]{"computer", "silver", "lenovo"},
                new String[]{"phone", "gold", "iphone"}
        }), "color", "silver"));

        System.out.println(countMatches(Util.buildNestListFromArray(new String[][]{
                new String[]{"phone", "blue", "pixel"},
                new String[]{"computer", "silver", "lenovo"},
                new String[]{"phone", "gold", "iphone"}
        }), "type", "phone"));
    }
}
