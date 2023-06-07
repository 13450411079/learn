package com.ssb.mysrpingboot01.src.threadLearn;

import lombok.Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

public class TestThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Object ob=new Object();
        Thread t1 = new Thread(() -> {
            try {
                synchronized (ob){
                    ob.wait();
                }
//                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("t1 running" + i);
            }
            System.out.println("t1 end");
        });


    Thread t2 = new Thread(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("t2 running" + i);
        }
        System.out.println("t2 end");
    });
    Thread t3 = new Thread(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("t3 running" + i);
        }
        System.out.println("t3 end");
//        synchronized (ob){
//            ob.notify();
//        }

    });
//        Lock
    t1.start();
    t2.start();
        t2.join();
        t3.start();
//        t1.join();
    t3.join();
        System.out.println(111);
        t1.interrupt();
        FutureTask f1=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                return 123;
            }
        });
        System.out.println(System.currentTimeMillis());
        Thread thread=new Thread(f1);
        thread.start();
//        f1.run();
//        f1.get();
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()+":"+f1.get());
}}

