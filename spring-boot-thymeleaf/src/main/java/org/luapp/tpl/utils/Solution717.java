package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/22
 **/
public class Solution717 {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 0 && i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 2;
                continue;
            }
            i += 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
