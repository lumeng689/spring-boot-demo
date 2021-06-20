package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Interview0506 {

    public static int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }

    public static void main(String[] args) {
        System.out.println(convertInteger(29, 15));
        System.out.println(convertInteger(1, 2));
    }
}
