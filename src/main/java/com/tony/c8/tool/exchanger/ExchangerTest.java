package com.tony.c8.tool.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tony on 2017/1/14.
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            public void run() {
                String A = "银行流水A";
                try {
                    String B = exgr.exchange(A);
                    System.out.println("get B :" + B);
                } catch (InterruptedException e) {

                }
            }
        });

        threadPool.execute(new Runnable() {
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exgr.exchange(B);
                    System.out.println("get A :" + A);
                } catch (InterruptedException e) {

                }
            }
        });

        threadPool.shutdown();
    }
}

/**
 * Exchanger用于进行线程间的数据交换。
 *
 * 它提供了一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 *
 * 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，
 *
 * 它会一直等待第二个线程也执行exchange方法，
 *
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，
 *
 * 将本线程生产出来的数据传递给对方。
 *
 * 如果两个线程有一个没有执行exchange方法，则会一直等待。
 *
 * 如果担心特殊情况发生，避免一直等待，可以用exchange(V x, longtimeout, TimeUnit unit)设置最大等待时长。
 *
 */


