package com.tony.c8.tool;

import java.util.concurrent.TimeUnit;

/**
 * Created by xugebing on 2016/12/27.
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser1 finish");
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser2 finish");
            }
        });

        parser1.start();
        parser2.start();

        //等待线程parser1和parser2终止
        parser1.join();
        parser2.join();

        System.out.println("all parser finish");
    }
}
