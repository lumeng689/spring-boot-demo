package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Interview0106 {

    public static String compressString1(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    public static String compressString2(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        char lastChar = ' ';
        for (char c : s.toCharArray()) {
            if (count == 0) {
                lastChar = c;
                count++;
            } else {
                if (c == lastChar) {
                    count++;
                } else {
                    sb.append(lastChar);
                    if (count > 1) {
                        sb.append(count);
                    }
                    lastChar = c;
                    count = 1;
                }
            }
        }

        sb.append(lastChar);
        sb.append(count);

        return sb.length() > s.length() ? s : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString1("aabcccccaaa"));
        System.out.println(compressString2("aabcccccaaa"));
        System.out.println(compressString1("abbccd"));
        System.out.println(compressString2("abbccd"));
    }
}
