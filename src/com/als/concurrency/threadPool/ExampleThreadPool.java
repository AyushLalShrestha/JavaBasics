package com.als.concurrency.threadPool;

/**
 * Example of working threadPool by hand.
 * ThreadPool is created with number of threads
 * and max number of tasks.
 * Threads are waiting in a thread pool for tasks.
 * As soon as execute() method takes place, it adds
 * new task into the queue and one of the idle threads
 * starts to execute this task until limit is reached.
 */
public class ExampleThreadPool {

    public static void main(String[] args) {
        //create the Thread pool
        ThreadPool threadPool = new ThreadPool(2, 3);

        //run 2 task 10 times
            for (int i = 0; i < 10; i++) {
            try {
                threadPool.execute(() -> {/*some task*/});
                threadPool.execute(() -> {/*some task*/});
            } catch (Exception e) {
                //some logic
            }

        }

        // Sleep to let other processes finish
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Interrupt logic
        }

        // Stop the thread pool
        threadPool.stop();

    }
}
