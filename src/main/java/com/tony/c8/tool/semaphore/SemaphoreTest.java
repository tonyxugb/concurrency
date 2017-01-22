package com.tony.c8.tool.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony on 2017/1/11.
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(5);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT; i++){
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        TimeUnit.SECONDS.sleep(2);
                        s.release();
                    } catch (InterruptedException e) {

                    }

                }
            });
        }

//        返回当前信号量中可用的许可证数
//        s.availablePermits();
//
//          返回正在等待获取许可证的线程数
//        s.getQueueLength();
//
//        是否有线程正在等待获取许可证
//        s.hasQueuedThreads();


        threadPool.shutdown();
    }

}

/**
 * 虽然提交给线程池30个线程去执行，但只允许10个并发执行。Semaphore的构造函数接受一个整型的数字，
 * 表示可用的许可证的数量。Semaphore(10)表示允许10个线程获取许可证，结业式最大并发数是10.
 * Semaphore的用法很简单，首先线程使用Semaphore的acquire()方法获取一个许可证，使用完之后
 * 调用release()方法归还许可证。
 *
 */
