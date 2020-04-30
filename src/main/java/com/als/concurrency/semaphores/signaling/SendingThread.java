package com.als.concurrency.semaphores.signaling;


import com.als.concurrency.semaphores.SemaphoreInterface;

public class SendingThread extends Thread {
    SemaphoreInterface semaphore = null;

    public SendingThread(SemaphoreInterface semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            // Do something, then signal i.e take
            System.out.println(Thread.currentThread().getName() +" | Sending:"+this.semaphore.getSignals());
            this.semaphore.take();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
