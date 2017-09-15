package com.tony.c6.container;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by xugebing on 2017/9/15.
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,40);

        Future<Integer> result = forkJoinPool.submit(task);

        System.out.println(result.get());

    }
}
