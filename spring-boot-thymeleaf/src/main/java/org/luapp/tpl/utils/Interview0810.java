package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Interview0810 {

    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        int[] idx = new int[]{1, 0, -1, 0, 1};

        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;

        for (int i = 0; i < idx.length - 1; i++) {
            int x = sr + idx[i];
            int y = sc + idx[i + 1];

            if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
                System.out.printf("x=%d,y=%d, oldColor: %d\n", x, y, oldColor);
                floodFill1(image, x, y, newColor);
            }
        }

        return image;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(sr,sc,image,image[sr][sc],newColor);
        return image;
    }

    public static void dfs(int x,int y,int[][] map,int originalColor, int newColor){
        if (originalColor==newColor){
            return ;
        }
        if (x>=map.length || x<0 || y>=map[0].length || y<0){
            return ;
        }
        if (map[x][y]==originalColor){
            map[x][y] = newColor;
            dfs(x+1,y,map,originalColor,newColor);
            dfs(x-1,y,map,originalColor,newColor);
            dfs(x,y+1,map,originalColor,newColor);
            dfs(x,y-1,map,originalColor,newColor);
        }
    }


    public static void main(String[] args) {
//        Util.printMatrix(floodFill(new int[][]{
//                new int[]{1, 1, 1},
//                new int[]{1, 1, 0},
//                new int[]{1, 0, 1}
//        }, 1, 1, 2));

        Util.printMatrix(floodFill1(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0}
        }, 0, 0, 2));
    }
}
