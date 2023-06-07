package com.ssb.mysrpingboot01.src.lockLearn;

import lombok.SneakyThrows;

public class DeadLockLearn {

    private static Integer a=1;
    private static Integer b=1;


    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                synchronized (a){

                    synchronized (b){

                        System.out.println(a++);
                    }

                }
            }}
        });

        Thread t2=new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){

                    synchronized (b){

                        synchronized (a){
                            System.out.println(b++);

                        }

                    }
                }
            }
        });
        t1.start();
        t2.start();


    }
}
