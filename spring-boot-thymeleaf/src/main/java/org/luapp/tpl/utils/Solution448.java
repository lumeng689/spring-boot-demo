package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] p = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            p[nums[i] - 1] = p[nums[i] - 1] + 1;
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) {
                missing.add(i + 1);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
