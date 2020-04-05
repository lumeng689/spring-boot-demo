package org.luapp.tpl.utils;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author: 86150
 * @create: 2020/03/30
 **/
public class JOLSample01 {
    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());

        JOLSample01.A a1 = new JOLSample01.A();
        a1.s = "hello";

        JOLSample01.A a2 = new JOLSample01.A();
        a2.s = "hello world, welcome.";
        System.out.println(ClassLayout.parseInstance(a1).toPrintable());
        System.out.println(ClassLayout.parseInstance(a2).toPrintable());
    }

    public static class A {
        // no fields
        String s = "";
    }
}
