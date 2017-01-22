package com.tony.c8.tool;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by xugebing on 2016/12/28.
 */
public class CyclicBarrierExample implements Runnable{

    private CyclicBarrier c = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

    private void count(){
        for(int i=0; i<4; i++){
            executor.execute(new Runnable() {

                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try {
                        c.await();
                    } catch (Exception e) {

                    }
                }
            });
        }
    }

    public void run() {
        int result = 0;
        for(Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
            result = result + sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        CyclicBarrierExample ce = new CyclicBarrierExample();
        ce.count();
    }


}
