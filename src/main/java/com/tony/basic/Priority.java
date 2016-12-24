package com.tony.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程优先级
 */
public class Priority {

    //方便所有线程及时感知到这个变量的变化，所以声明为volatile
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception{
        List<Job> jobs = new ArrayList<Job>();
        for(int i=0; i < 10; i++){
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for(Job job : jobs){
            System.out.println("Job priority:" + job.priority + ",count:" + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                //执行Thread.yield()方法后，当前线程立马让出CPU执行时间，然后和其他线程一起竞争CPU执行时间，
                //有可能是别的线程争取到了执行时间，也有可能还是自己，然后jobCount++有机会执行一次；
                Thread.yield();
                jobCount++;
            }
        }
    }
}

/**
 *   output:
 *
 *   Job priority:1,count:3614786
 *   Job priority:1,count:515309
 *   Job priority:1,count:5143164
 *   Job priority:1,count:4873313
 *   Job priority:1,count:3565410
 *   Job priority:10,count:8537048
 *   Job priority:10,count:8719964
 *   Job priority:10,count:28850616
 *   Job priority:10,count:8856854
 *   Job priority:10,count:8586357
 *
 *   优先级高的执行次数要明显高于优先级低的
 */

/**
 * Thread.yield()
 *
 * 示意线程调度器当前线程愿意放弃对处理器的使用，线程调度器可以自由忽略这个示意。
 * yield尝试改进过分使用CPU线程的进度，该方法的使用需要联合性能分析和标记来保证实际有预期的效果。
 * 该方法很少被使用，在测试或dubug时或许有用，这时通过为了重现由于竞争条件导致的bug。
 * 在设计并发控制构想时或许有用，比如java.util.concurrent.locks包下面的类。
 *
 * 当一个线程调用了这个方法后，它就会把自己CPU执行的时间让出来，让自己或者其他的线程运行。
 * 打个比方：现在有很多人在排队上厕所，好不容易轮到这个人上厕所了，
 * 突然这个人说：“我要和大家来个竞赛，看谁先抢到厕所！”，然后所有的人在同一起跑线冲向厕所，
 * 有可能是别人抢到了，也有可能他自己有抢到了。
 * 我们还知道线程有个优先级的问题，那么手里有优先权的这些人就一定能抢到厕所的位置吗?
 * 不一定的，他们只是概率上大些，也有可能没特权的抢到了。
 * http://blog.csdn.net/dabing69221/article/details/17426953
 */


