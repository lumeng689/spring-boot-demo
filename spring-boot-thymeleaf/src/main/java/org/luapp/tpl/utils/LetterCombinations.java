package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/04/19
 **/
public class LetterCombinations {


    char[][] m = new char[][]{
            {},
            {},
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'}, // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    void dfs(String str, int index, StringBuilder sb, List<String> res) {
        if (index == str.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : m[str.charAt(index) - '0']) {
            sb.append(c);
            dfs(str, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations s = new LetterCombinations();
        s.letterCombinations("234");
    }
}
