package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/11
 **/
public class Solution419 {

    public static int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if ((i <= 0 || board[i - 1][j] != 'X') && (j <= 0 || board[i][j - 1] != 'X')) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][]{
                new char[]{'X', ',', '.', 'X'},
                new char[]{',', ',', '.', 'X'},
                new char[]{',', ',', '.', 'X'},
                new char[]{',', ',', '.', 'X'}
        }));

        System.out.println(countBattleships(new char[][]{
                new char[]{'X', ',', '.', 'X'}
        }));
    }
}
