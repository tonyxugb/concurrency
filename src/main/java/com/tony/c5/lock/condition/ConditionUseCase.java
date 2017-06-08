package com.tony.c5.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xugebing on 2017/2/17.
 */
public class ConditionUseCase {

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try{
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
