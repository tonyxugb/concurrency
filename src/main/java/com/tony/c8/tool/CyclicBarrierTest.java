package com.tony.c8.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xugebing on 2016/12/27.
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try{
            c.await();
        }catch (Exception e){

        }
        System.out.println(2);
    }
}

/**
 * CyclicBarrier构造函数的入参表示屏障拦截的线程数，
 * 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，
 * 然后当前线程被阻塞，
 * 直到最后一个线程到达屏障时，
 * 屏障才会开门，
 * 所有被屏障拦截的线程才会继续运行。
 *
 * 如果new CyclicBarrier(2)修改成new CyclicBarrier(3)，
 * 则主线程和子线程会永远等待，
 * 因为没有第三个线程执行await方法，
 * 即没有第三个线程到达屏障，
 * 所以之前到达屏障的两个线程都不会继续执行。
 */
