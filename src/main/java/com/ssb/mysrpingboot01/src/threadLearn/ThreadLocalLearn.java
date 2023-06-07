package com.ssb.mysrpingboot01.src.threadLearn;

public class ThreadLocalLearn {

    private static ThreadLocal<String> tl=new ThreadLocal<>();

    public static void main(String[] args) {


         Thread t1=new Thread(new Runnable() {
             @Override
             public void run() {
                ThreadLocalLearn.tl.set("abc");
                 System.out.println(ThreadLocalLearn.tl.get());
                 ThreadLocalLearn.tl.remove();
             }
         });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalLearn.tl.set("efg");
                System.out.println(ThreadLocalLearn.tl.get());
                ThreadLocalLearn.tl.remove();
            }
        });
        t1.start();
        t2.start();

    }
}
