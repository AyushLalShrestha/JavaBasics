package com.als.concurrency.semaphores;

/**
 * Simple implementation of semaphore with incrementing signals field
 */
public class CountingSemaphore implements SemaphoreInterface {

    private int signals = 0;

    public synchronized void take() {
        this.signals++;
        this.notify();
    }

    public synchronized void release() {
        while (this.signals == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        this.signals--;
    }


    public int getSignals() {
        return signals;
    }
}
