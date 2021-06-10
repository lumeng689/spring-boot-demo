package org.luapp.tpl.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: 86150
 * @create: 2021/06/06
 **/
public class Solution682 {

    public static int calPoints(String[] ops) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    if (ret.size() > 0) {
                        ret.remove(ret.size() - 1);
                    }
                    break;
                case "D":
                    if (ret.size() > 0) {
                        ret.add(ret.get(ret.size() - 1) * 2);
                    }
                    break;
                case "+":
                    if (ret.size() > 1) {
                        ret.add(ret.get(ret.size() - 1) + ret.get(ret.size() - 2));
                    }
                    break;
                default:
                    ret.add(Integer.valueOf(ops[i]));
                    break;
            }
        }

        Optional<Integer> sum = ret.stream().reduce((a, b) -> a + b);
        return sum.get();
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1"}));
    }
}
