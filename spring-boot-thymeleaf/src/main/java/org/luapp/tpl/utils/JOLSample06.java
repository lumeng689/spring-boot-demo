package org.luapp.tpl.utils;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author: 86150
 * @create: 2020/03/25
 **/
public class JOLSample06 {
    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A {
        boolean a;
    }

    public static class B extends A {
        boolean b;
    }

    public static class C extends B {
        boolean c;
    }
}
