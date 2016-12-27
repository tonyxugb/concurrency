package com.tony.c4.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by xugebing on 2016/12/27.
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread previous = Thread.currentThread();

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable{

        private Thread thread;

        public Domino(Thread thread){
            this.thread = thread;
        }

        public void run(){
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + "terminate.");
        }
    }
}

/**
     main terminate.
     0terminate.
     1terminate.
     2terminate.
     3terminate.
     4terminate.
     5terminate.
     6terminate.
     7terminate.
     8terminate.
     9terminate.
 */
