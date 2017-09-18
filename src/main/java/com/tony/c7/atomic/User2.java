package com.tony.c7.atomic;

/**
 * Created by xugebing on 2017/9/18.
 */
public class User2 {

    private String name;

    public volatile int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
