package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution1309 {

    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' - 1 + 'a'));
                i = i + 3;
            } else {
                sb.append((char) (s.charAt(i) - '0' - 1 + 'a'));
                i = i + 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets("1326#"));
        System.out.println(freqAlphabets("25#"));
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
