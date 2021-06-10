package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/07
 **/
public class Solution1018 {

    public static List<Boolean> prefixesDivBy51(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        System.out.println(nums.length);
        List<Boolean> ans = new ArrayList<>(nums.length);

        int lastNum = 0;
        for (int i = 0; i < nums.length; i++) {
            lastNum = (lastNum << 1) + nums[i];
            if (lastNum % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        Util.printList(prefixesDivBy5(new int[]{0, 1, 1}));
//        Util.printList(prefixesDivBy5(new int[]{1, 1, 1}));
//        Util.printList(prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
//        Util.printList(prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        Util.printList(prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}));
    }
}
