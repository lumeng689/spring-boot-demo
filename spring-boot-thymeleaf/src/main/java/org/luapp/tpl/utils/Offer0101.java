package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Offer0101 {

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(fib(0));
//        System.out.println(fib(2));
//        System.out.println(fib(3));
//        System.out.println(fib(5));
    }
}
