package com.als.concurrency.threadPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of BlockingQueue. Holder of tasks.
 */
public class SimpleBlockingQueue {

    private List queue = new LinkedList();
    private int limit = 0;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) {
        while (this.queue.size() == this.limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
        System.out.println(Thread.currentThread().getName() + " | Task added | Number of tasks: " + getQueueSize());
    }


    public synchronized Object dequeue() {
        while (this.queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " | Task  taken. | Number of tasks:"+(getQueueSize()-1));
        return this.queue.remove(0);
    }


    public int getQueueSize() {
        return queue.size();
    }
}
