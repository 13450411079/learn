package com.ssb.mysrpingboot01.src.lockLearn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock  r =new ReentrantReadWriteLock();
        r.writeLock().lock();
    }
}
