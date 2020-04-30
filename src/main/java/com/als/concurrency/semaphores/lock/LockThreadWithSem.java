package com.als.concurrency.semaphores.lock;

import com.als.concurrency.semaphores.SemaphoreInterface;

/**
 * Convenient realisation of working thread from LockExample
 */
public class LockThreadWithSem extends Thread{

      private SemaphoreInterface semaphoreInterface;


    public LockThreadWithSem(SemaphoreInterface semaphoreInterface) {
        this.semaphoreInterface = semaphoreInterface;
    }


    @Override
    public void run() {
        while (true) {
            semaphoreInterface.take();
            try {
                System.out.println(Thread.currentThread().getName() + " | " + semaphoreInterface.getSignals());
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            finally {
                semaphoreInterface.release();
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
