package com.ytp.music.entity;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ytp
 */
@Data
public class Item {

    private Integer categoryId;

    private String categoryName;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(" t1 加锁");
                System.out.println("t1 start await");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 end await");
                lock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(" t2 加锁");
                System.out.println("t2 start signal");
                condition.signal();
                System.out.println("t2 end signal");
                lock.unlock();
            }
        });
        thread2.start();
    }
}
