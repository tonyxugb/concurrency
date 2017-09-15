package com.tony.c6.container;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xugebing on 2017/9/15.
 */
public class ContainerTest {

    @Test
    public void testQueue(){

        ConcurrentLinkedQueue<Cat> queue = new ConcurrentLinkedQueue<Cat>();

        //Add element at the tail of this queue.
        queue.add(new Cat("A01", "Donna"));

        // There is no difference between add method and offer method
        // implementation of add method :
        //    public boolean add(E e) {
        //        return offer(e);
        //    }
        queue.offer(new Cat("A02", "Donald"));

        //Retrive and remove the head of this queue
        Cat cat = queue.poll();

        //Retrieves, but does not remove, the head of this queue.
        Cat cat2 = queue.peek();

        //
        boolean isEmpty = queue.isEmpty();
        int size = queue.size();
        boolean isContain = queue.contains(cat);
        queue.remove(cat);

    }
}

