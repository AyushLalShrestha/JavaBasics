package com.als.concurrency;

import java.util.concurrent.*;


class ThreadExecutors {

    public void executorServices() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous Task");
            }
        });

        executorService.shutdown();
    }

    public void executorServiceEnhanced() {
        ExecutorService executorService = new ThreadPoolExecutor(6,
                15, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000, false),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous Task");
            }
        });

        executorService.shutdown();
    }
}