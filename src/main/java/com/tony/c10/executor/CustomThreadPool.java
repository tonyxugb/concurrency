package com.tony.c10.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * <p>
 * Created by xugebing on 2018/2/6.
 */
public class CustomThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                20,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new ThreadFactoryBuilder().setNameFormat("my-task-%d").build(),
                new RejectPolicy()
        );

        for (int i = 0; i < 30; i++) {
            executor.execute(() ->{
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ":doing");
                    TimeUnit.SECONDS.sleep(30);
                    System.out.println(threadName + ":done");
                } catch (InterruptedException e) {

                }
            });
        }

    }
}
