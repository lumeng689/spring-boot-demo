package org.luapp.tpl.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Util {
    public static void printArray(int[] ret) {
        if (ret == null || ret.length <= 0) {
            System.out.println("");
        }

        System.out.println(StringUtils.join(ret, ','));
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static void printNestList(List<List<Integer>> lists) {
        for (List<Integer> subList : lists) {
            for (int i : subList) {
                System.out.println(i + "\t");
            }
            System.out.println();
        }
    }
}
