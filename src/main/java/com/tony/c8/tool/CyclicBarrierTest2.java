package com.tony.c8.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by xugebing on 2016/12/27.
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("sub-1");
                    c.await();
                    System.out.println("sub-2");
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try{
            System.out.println("main-1");
            c.await();
            System.out.println("main-2");
        }catch (Exception e){

        }
        System.out.println(2);
    }

    static class A implements Runnable{
        public void run() {
            System.out.println("A-1");
            System.out.println(3);
            System.out.println("A-2");
        }
    }
}

/**
 * new CyclicBarrier(2, new A()),当两个线程执行了await()方法到达屏障后，
 * 优先执行A的run()方法，执行完A之后，再继续其他两个线程
 *
 *   Output:
     main-1
     sub-1
     A-1
     3
     A-2
     sub-2
     1
     main-2
     2
 */
