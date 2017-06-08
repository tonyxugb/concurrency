package com.tony.c5.lock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 共享锁示例
 *
 * 该工具在同一时刻，至多只允许两个线程同时访问，超过两个线程的访问将被堵塞
 *
 * Created by xugebing on 2017/1/24.
 */
public class TwinsLock implements Lock {

    //同步状态初始值设置为2
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count){
            if(count <= 0 && count > 2){
                throw new IllegalArgumentException("count must be larger than zero and less than two");
            }
            setState(count);
        }

        //同一时刻允许多个线程同时访问，显然是共享式访问，需要使用队列同步器的acquireShared方法
        public int tryAcquireShared(int reduceCount){
            for(;;){
                int current = getState();
                int newCount = current - reduceCount;
                if(newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        public boolean tryReleaseShared(int returnCount){
            for(;;){
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public Condition newCondition() {
        return null;
    }
}
