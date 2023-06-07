package com.ssb.mysrpingboot01.src.collectionLearn;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.*;

public class QueueLearn {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue<Integer>(10);
//        arrayBlockingQueue.add(10);
//        arrayBlockingQueue.offer(20);
//        arrayBlockingQueue.poll();
//
//        Iterator<Integer> iterator = arrayBlockingQueue.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        CopyOnWriteArrayList<String> a =new CopyOnWriteArrayList<>();
//        a.add("123");
//        a.add("123");
//        a.add("123");
//        byte[] bytes=new byte[10];
//        String b=bytes.

        PriorityBlockingQueue<Integer> p=new PriorityBlockingQueue();
        p.offer(10);
        p.offer(123);
        p.offer(50);
        p.offer(60);
        p.offer(200);
//        while(true){
//            System.out.println(p.take());
//        }
        System.out.println(JSONObject.toJSONString(p));

    }
}
