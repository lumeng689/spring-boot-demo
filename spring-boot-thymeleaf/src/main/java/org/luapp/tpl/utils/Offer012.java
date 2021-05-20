package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer012 {

    public static boolean exist(char[][] board, String word) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println(exist(new char[][]{
                new char[]{'a', 'b'},
                new char[]{'c', 'd'}
        }, "abcd"));
    }
}
