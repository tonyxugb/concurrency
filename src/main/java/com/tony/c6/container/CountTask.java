package com.tony.c6.container;

import java.util.concurrent.RecursiveTask;

/**
 * Created by xugebing on 2017/9/15.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2; //阈值

    private int start;

    private int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;

        if(canCompute){
            for(int i = start; i <= end; i++){
                sum += i;
            }
        }else{
            int middle = (start + end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            //子任务在调用fork()方法时，又会进入compute方法，
            //看看当前子任务是否需要继续分割成子任务，
            //如果不需要继续分割，就执行当前子任务并返回结果；
            //如果需要继续分割，就递归下去；
            leftTask.fork();
            rightTask.fork();

            //使用join()方法会等待子任务执行完并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }
}
