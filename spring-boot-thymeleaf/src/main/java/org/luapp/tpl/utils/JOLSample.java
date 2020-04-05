package org.luapp.tpl.utils;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author: 86150
 * @create: 2020/03/25
 **/
public class JOLSample {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
        System.out.println("==========================================");
        System.out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A {
        boolean bo1, bo2;
        byte b1, b2;
        char c1, c2;
        double d1, d2;
        float f1, f2;
        int i1, i2;
        long l1, l2;
        short s1, s2;
    }

    public static class B extends A {
        int b;
    }

    public static class C extends B {
        int c;
    }
}
