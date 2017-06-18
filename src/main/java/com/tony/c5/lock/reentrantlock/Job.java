package com.tony.c5.lock.reentrantlock;

import java.util.concurrent.locks.Lock;

/**
 * Created by xugebing on 2017/6/9.
 */
public class Job extends Thread {
    private Lock lock;
    public Job(Lock lock){
        this.lock = lock;
    }
    public void run(){
        System.out.println("Locked by" + lock);
    }
}
