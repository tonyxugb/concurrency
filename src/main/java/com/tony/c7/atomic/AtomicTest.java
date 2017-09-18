package com.tony.c7.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by xugebing on 2017/9/18.
 */
public class AtomicTest {

    @Test
    public void testBasic(){
        //原子更新基本类型
        AtomicInteger ai = new AtomicInteger(1);
        System.out.println(ai.addAndGet(2));
        ai.compareAndSet(3, 5);
        System.out.println(ai.get());
    }


    @Test
    public void testArray(){
        int[] value = new int[]{1,2};
        AtomicIntegerArray ai = new AtomicIntegerArray(value);
        ai.addAndGet(0, 10);
        System.out.println(ai.get(0));
    }


    @Test
    public void testReference(){
        AtomicReference<User> atomicUserRef = new AtomicReference<User>();
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        atomicUserRef.set(user);

        User updateUser = new User();
        updateUser.setName("李四");
        updateUser.setAge(20);

        atomicUserRef.compareAndSet(user, updateUser);

        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getAge());
    }


    @Test
    public void testFieldUpdate(){
        AtomicIntegerFieldUpdater<User2> a = AtomicIntegerFieldUpdater.newUpdater(User2.class, "age");
        User2 conan = new User2();
        conan.setName("张三");
        conan.setAge(10);
        a.getAndAdd(conan, 5);
        System.out.println(a.get(conan));
    }

}
