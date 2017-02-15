package com.tony.c5.lock.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例
 *
 * 使用非线程安全的HashMap作为缓存的实现，同时使用读写锁的读锁和写锁来保证cache是线程安全的
 *
 * Created by xugebing on 2017/2/15.
 */
public class Cache {

    static Map<String,Object> map = new HashMap<String,Object>();

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock r = rwl.readLock();

    static Lock w = rwl.writeLock();

    //获取一个key对应的value
    public static Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value，并返回旧的value
    public static Object put(String key, Object value){
        w.lock();
        try{
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }

    //清空所有内容
    public static void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }

}
