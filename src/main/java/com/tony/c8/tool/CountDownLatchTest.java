package com.tony.c8.tool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xugebing on 2016/12/27.
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println(3);
    }
}

/**
 * CountDownLatch构造函数接收一个int类型的参数作为计数器，
 * 如果你想等待N个点完成，这里就传入N，
 * 当我们调用CountDownLatch的countDown()方法时，
 * N就会减1，
 * CountDownLatch的await()方法会阻塞当前线程，
 * 直到N变成0
 */
