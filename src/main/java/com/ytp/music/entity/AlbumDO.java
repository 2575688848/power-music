package com.ytp.music.entity;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ytp
 */
@Data
public class AlbumDO {

    private String albumMID;

    private String albumName;

    private String albumPic;

    private String publicTime;

    private String singerName;

    private Integer song_count;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(1);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Thread b = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
//                lock.lock();
//                try {
//                    System.out.println("b 等待");
//                    condition1.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                while (true) {
                    lock.lock();
                    condition.signal();
                    System.out.println("线程b。。");
                    Thread.sleep(2000);
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread a = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    condition.signal();
                    System.out.println("线程a。。");
                    Thread.sleep(2000);
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        b.start();
        Thread.sleep(1000);
        a.start();
        System.out.println("主线程结束。。");
    }

//    public static void main(String[] args) throws Exception {
//
//        Object lock = new Object();
//        Thread a = new Thread(() -> {
//            while (true) {
//                synchronized (lock) {
//                    lock.notify();
//                    try {
//                        Thread.sleep(2000);
//                        System.out.println("1");
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        Thread b = new Thread(() -> {
//            while (true) {
//                synchronized (lock) {
//                    lock.notify();
//                    try {
//                        Thread.sleep(2000);
//                        System.out.println("2");
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            }
//        });
//        a.start();
//        b.start();
//    }

//    public static void main(String[] args) throws InterruptedException {
//
//        Thread thread = Thread.currentThread();
//        //释放许可
//        LockSupport.unpark(thread);
//        System.out.println("hhshha");
//        // 获取许可
//        LockSupport.park();
//        System.out.println("哈哈哈哈");
//        LockSupport.unpark(thread);
//        LockSupport.park();
//        System.out.println("b");
//        LinkedList<Integer> stack = new LinkedList();
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        System.out.println(stack.poll());
//        System.out.println(stack.poll());
//        System.out.println(stack.pop());
//    }

    public static ListNode test(ListNode root) {
        if (root.next == null) {
            return root;
        }
        ListNode next = root.next;
        ListNode result = test(root.next);
        next.next = root;
        root.next = null;
        return result;
    }

    public static boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        if (chars.length > chart.length) {
            return false;
        }
        int i = 0, j = 0;
        while (i < chars.length && j < chart.length) {
            if (chars[i] == chart[j]) {
                if (i == chars.length - 1) {
                    return true;
                }
                i++;
                j++;
            } else {
                j++;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
}















