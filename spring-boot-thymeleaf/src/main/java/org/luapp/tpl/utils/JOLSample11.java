package org.luapp.tpl.utils;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author: 86150
 * @create: 2020/03/25
 **/
public class JOLSample11 {

    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(new A()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new B()).toPrintable());
    }

    public static class A {
        // no fields
    }

    public static class B {
        // no fields
    }
}
