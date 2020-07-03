package org.luapp.tpl.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: 86150
 * @create: 2020/04/22
 **/
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("in t1");
                LockSupport.park();
                System.out.println("exit t1");
            }
        };

        t1.start();

        System.out.println("in main");

        TimeUnit.SECONDS.sleep(3);

        LockSupport.unpark(t1);
        System.out.println("exit main");
    }
}
