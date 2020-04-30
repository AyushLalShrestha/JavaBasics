package com.als.concurrency.semaphores.signaling;

import com.als.concurrency.semaphores.BoundedSemaphore;

/**
 * Example of signaling use case of semaphore
 */
public class SignalingExample {

    public static void main(String[] args) {
        //CountingSemaphore cs = new CountingSemaphore();
        BoundedSemaphore cs = new BoundedSemaphore(5);

        new SendingThread(cs).start();
        new ReceivingThread(cs).start();
    }
}
