package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/01
 **/
public class Solution999 {

    public static int numRookCaptures(char[][] board) {

        int rRow = -1;
        int rCol = -1;

        for (int i = 0; i < 8; i++) {
            boolean found = false;
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    found = true;
                    rRow = i;
                    rCol = j;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int ans = 0;

        for (int i = 0; i < 4; i++) {
            for (int step = 0; ; step++) {
                int tx = rRow + step * dx[i];
                int ty = rCol + step * dy[i];

                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }

                if (board[tx][ty] == 'p') {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRookCaptures(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'R', '.', '.', '.', 'p'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println(numRookCaptures(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                new char[]{'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}

        }));

        System.out.println(numRookCaptures(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
