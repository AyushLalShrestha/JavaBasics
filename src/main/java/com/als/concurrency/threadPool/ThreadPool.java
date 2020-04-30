package com.als.concurrency.threadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom implementation to execute pool of threads
 */
public class ThreadPool {

    private SimpleBlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;


    // Initialize taskQueue, create threads & start them
    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new SimpleBlockingQueue(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            threads.add(new PoolThread(taskQueue));
        }

        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    // add the task to our queue
    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQueue.enqueue(task);
    }


    // Stop the thread execution
    public synchronized void stop() {
        this.isStopped = true;
        for (PoolThread thread : threads) {
            thread.stop();
        }
    }
}
