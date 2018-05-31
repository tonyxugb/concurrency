package com.tony.c10.executor;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Future<String> future = executor.submit(() ->{
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ":doing");
                    TimeUnit.SECONDS.sleep(30);
                    System.out.println(threadName + ":done");
                    return "some";
            });

            futures.add(future);
        }

        try {
            //以抛异常的方式结束等待
            System.out.println(futures.get(0).get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        } catch (TimeoutException e) {

        }


        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }

    }
}
