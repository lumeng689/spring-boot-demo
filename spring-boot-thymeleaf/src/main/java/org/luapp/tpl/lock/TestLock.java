package org.luapp.tpl.lock;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 86150
 * @create: 2021/06/02
 **/
public class TestLock {

    public static final int maxNum = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final TestLock testLock = new TestLock();
        testLock.putThread("线程1");
        testLock.putThread("线程2");
        testLock.putThread("线程3");
        testLock.putThread("线程4");
        testLock.putThread("线程5");
        testLock.readThread("读线程");
    }

    public void readThread(String name) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setName(name);
        thread.start();


    }

    public void read() throws InterruptedException {
        lock.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            System.out.println("read:" + count.decrementAndGet());
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }


    public void putThread(String name) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName(name);
        thread.start();
    }

    public void print() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("threadName" + Thread.currentThread().getName());
            while (count.get() == maxNum) {
                notFull.await();
            }
            System.out.println("put:" + count.getAndIncrement() + " threadName" + Thread.currentThread().getName());
            System.out.println(new Date());
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }


}