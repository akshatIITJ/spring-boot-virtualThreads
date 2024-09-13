package com.akshat.multithreading;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void performAsyncTask() {
        System.out.println("Async task started: " + Thread.currentThread());
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Async task finished: " + Thread.currentThread());
    }
}
