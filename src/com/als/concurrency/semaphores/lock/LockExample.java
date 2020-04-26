package com.als.concurrency.semaphores.lock;

import com.als.concurrency.semaphores.BoundedSemaphore;

/**
 * Example of lock use case of semaphore.
 * If parameter == 1 => mutex.
 * if parameter >1 => classic N semaphore.
 */
public class LockExample {

    public static void main(String[] args) {

        BoundedSemaphore boundedSemaphore = new BoundedSemaphore(5);

        new Thread(() -> {
            while (true) {
                boundedSemaphore.take();
                try {
                    System.out.println(Thread.currentThread().getName() + " | " + boundedSemaphore.getSignals());
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    boundedSemaphore.release();
                }
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                boundedSemaphore.take();
                try {
                    System.out.println(Thread.currentThread().getName() + " | " + boundedSemaphore.getSignals());
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    boundedSemaphore.release();
                }
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                boundedSemaphore.take();
                try {
                    System.out.println(Thread.currentThread().getName() + " | " + boundedSemaphore.getSignals());
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    boundedSemaphore.release();
                }
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }).start();


        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
        new LockThreadWithSem(boundedSemaphore).start();
    }

}
