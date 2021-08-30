package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/29
 **/
public class Solution228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int i = 0;
        int n = nums.length;

        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }

            int high = i - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(Integer.valueOf(nums[high]));
            }

            ans.add(sb.toString());
        }

        return ans;
    }

    public static void main(String[] args) {
        Util.printList(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        Util.printList(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        Util.printList(summaryRanges(new int[]{}));
        Util.printList(summaryRanges(new int[]{-1}));
        Util.printList(summaryRanges(new int[]{0}));
    }
}
