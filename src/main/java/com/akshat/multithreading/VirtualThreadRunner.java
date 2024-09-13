package com.akshat.multithreading;

import java.util.stream.IntStream;

public class VirtualThreadRunner {
    public static void main(String[] args) throws InterruptedException {
//        Thread.ofPlatform().start(() ->
//                System.out.println("Platform Thread : " + Thread.currentThread().getName()));
//        System.out.println("-------------------");
//
//        Thread.ofVirtual().start(() -> {
//            System.out.println("whatever bro");
//                System.out.println("Virtual Thread : " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        );
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        var start = System.currentTimeMillis();
        var totalThread = 10000;
        var threads = IntStream.range(0, totalThread)
                .mapToObj(
                        thCount -> Thread.ofVirtual().unstarted(() -> {
                        })).toList();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        var end = System.currentTimeMillis();
        System.out.println("millis used to launch " + totalThread + "vthreads:" + (end - start) + "ms");

        Thread thread = Thread.ofVirtual().unstarted(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread());
        });

        thread.start();
        thread.join();

    }
}
