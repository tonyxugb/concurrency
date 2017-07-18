package com.tony.c5.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {

    private Object[] items;

    // 添加的下标，删除的下标和数组当前数量
    private int addIndex;

    private int removeIndex;

    private int count;

    private Lock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                //当前线程进入等待状态，直到被通知(signal)或中断
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            //唤醒一个等待在Condition上的线程
            //该线程从等待方法返回前必须获得与Condition相关联的锁
            //在notEmpty.await()未执行之前，
            //notEmpty这个condition的等待队列上没有等待的线程，
            //执行signal()也无妨
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }
}
