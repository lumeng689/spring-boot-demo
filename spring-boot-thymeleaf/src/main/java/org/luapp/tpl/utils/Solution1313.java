package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/15
 **/
public class Solution1313 {

    public static int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length <=0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();

        for (int i =0;i < nums.length;i=i+2) {
            for (int j = 0;j < nums[i];j++) {
                list.add(nums[i+1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i ++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Util.printArray(decompressRLElist(new int[]{1, 2, 3, 4}));
        Util.printArray(decompressRLElist(new int[]{1, 1, 2, 3}));
    }
}
