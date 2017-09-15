package com.tony.c6.container;

/**
 * Created by xugebing on 2017/9/15.
 */
public class Cat {

    private String id;

    private String name;

    public Cat(){

    }

    public Cat(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
