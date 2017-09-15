package com.tony.c5.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    private static CountDownLatch start;

    /**
     *    公平锁的执行结果：
     *    Lock by [0], Waiting by [1, 3, 4, 2]
     *    Lock by [1], Waiting by [3, 4, 2, 0]
     *    Lock by [3], Waiting by [4, 2, 0, 1]
     *    Lock by [4], Waiting by [2, 0, 1, 3]
     *    Lock by [2], Waiting by [0, 1, 3, 4]
     *    Lock by [0], Waiting by [1, 3, 4, 2]
     *    Lock by [1], Waiting by [3, 4, 2]
     *    Lock by [3], Waiting by [4, 2]
     *    Lock by [4], Waiting by [2]
     *    Lock by [2], Waiting by []
     *
     *    公平锁每次都是从同步队列中的第一个节点获取到锁
     */
    @Test
    public void fair() {
        testLock(fairLock);
    }

    /**
     * Lock by [1], Waiting by [3, 0, 4, 2]
     * Lock by [1], Waiting by [3, 0, 4, 2]
     * Lock by [3], Waiting by [0, 4, 2]
     * Lock by [3], Waiting by [0, 4, 2]
     * Lock by [0], Waiting by [4, 2]
     * Lock by [0], Waiting by [4, 2]
     * Lock by [4], Waiting by [2]
     * Lock by [4], Waiting by [2]
     * Lock by [2], Waiting by []
     * Lock by [2], Waiting by []
     *
     *  非公平锁出现了一个线程连续获取锁的情况。之所以出现这种情况，
     *  是因为在非公平锁中，当一个线程请求锁时，只要获取了同步状态即成功获取锁，
     *  在这个前提下，刚释放锁的线程再次获取同步状态的几率会非常大，
     *  使得其他线程只能在同步队列中等待
     */
    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        start = new CountDownLatch(1);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock);
            thread.setName("" + i);
            thread.start();
        }

        // sleep 2秒的目的是为了保证5个线程都阻塞在await()方法处，
        // 当start.countDown()时，所有线程开始竞争锁
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }

        start.countDown();

    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {

                //在此阻塞，等待start.countDown()之后，便开始竞争获取锁了
                start.await();
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by [" + getName() + "], Waiting by " + ((ReentrantLock2) lock).getQueuedThreads());
                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }

        public String toString() {
            return getName();
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        private static final long serialVersionUID = -6736727496956351588L;

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
