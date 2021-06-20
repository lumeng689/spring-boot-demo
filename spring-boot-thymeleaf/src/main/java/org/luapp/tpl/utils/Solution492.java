package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution492 {

    public static int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        int length;
        while (area % width != 0) {
            width--;
        }
        length = area / width;
        return new int[]{length, width};
    }

    public static void main(String[] args) {
        Util.printArray(constructRectangle(4));
    }
}
