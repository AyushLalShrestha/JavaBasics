package com.als.concurrency.threadPool;

/**
 * Implementation of the threads that execute the tasks
 */
public class PoolThread extends Thread{

    private SimpleBlockingQueue taskQueue = null;
    private boolean isStopped = false;


    public PoolThread(SimpleBlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }


    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable)taskQueue.dequeue();
                runnable.run();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
