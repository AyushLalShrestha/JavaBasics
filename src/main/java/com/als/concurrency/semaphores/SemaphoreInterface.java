package com.als.concurrency.semaphores;

/**
 * Basic interface of semaphore to implement
 */
public interface SemaphoreInterface {

    public void take();

    public void release();

    public int getSignals();
}
