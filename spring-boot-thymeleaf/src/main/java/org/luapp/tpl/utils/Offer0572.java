package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Offer0572 {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();

        int sum = 0, limit = (target - 1) / 2;
        for (int i = 1; i <= limit; i++) {
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        res[k - i] = k;
                    }
                    ans.add(res);
                    sum = 0;
                    break;
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Util.printMatrix(findContinuousSequence(9));
        Util.printMatrix(findContinuousSequence(15));
    }
}
