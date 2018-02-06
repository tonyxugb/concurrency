package com.tony.c10.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xugebing on 2018/2/6.
 */
public class RejectPolicy implements RejectedExecutionHandler{

    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("thread pool is full");
    }
}
