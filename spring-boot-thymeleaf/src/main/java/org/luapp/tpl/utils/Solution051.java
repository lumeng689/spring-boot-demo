package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution051 {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if (n <= 0) {
            return res;
        }

        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }

        backTrack(n, 0, chessBoard, res);
        return res;
    }

    private static void backTrack(int n, int row, char[][] chessBoard, List<List<String>> res) {
        if (row == n) {
            List<String> item = new ArrayList<>();
            for (char[] chars : chessBoard) {
                item.add(String.copyValueOf(chars));
            }
            res.add(item);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTrack(n, row + 1, chessBoard, res);
                chessBoard[row][col] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, int n, char[][] chessBoard) {

        // 检查列
        for (int i = 0; i < n; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
