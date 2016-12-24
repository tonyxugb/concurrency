package com.tony.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by tony on 2016/12/25.2
 */
public class ThreadState {

    public static void main(String[] args){

        //TIMED_WAITING，超时等待，可以在指定的时间内自动返回
        new Thread(new TimeWating(), "TimeWaitingThread").start();

        //WAITING on object monitor，获取了Waiting.class的monitor
        new Thread(new Waiting(), "WatingThread").start();

        //TIMED_WAITING，占有Blocked.class的monitor
        new Thread(new Blocked(), "BlockThread-1").start();

        //BLOCKED，等待获取Blocked.class的monitor
        new Thread(new Blocked(), "BlockThread-2").start();
    }


    //该线程不断睡眠
    static class TimeWating implements Runnable{
        public void run() {
            while (true){
                sleep(100);
            }
        }
    }

    static class Waiting implements Runnable{
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

    static class Blocked implements Runnable{
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    //sleep时是否释放锁？
                    sleep(100);
                }
            }
        }
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
