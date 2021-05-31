package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/29
 **/
public class Interview1701 {
    public static int add(int a, int b) {
        while (b != 0) {
            //tempXOR把相加不进位的位数设为1
            int tempXOR = a ^ b;
            //tempAnd把相加进位的位数设为1,进位1
            int tempAnd = (a & b) << 1;
            a = tempXOR;
            b = tempAnd;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 1));
    }
}
