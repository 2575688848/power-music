package com.ytp.music.guava;

import com.google.inject.internal.asm.$Handle;
import lombok.Data;

import java.util.List;

/**
 * @author pinge
 */
@Data
public class Singleton {

//    // 饿汉
//
//    private static final Singleton INSTANCE = new Singleton();
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        return INSTANCE;
//    }

//    // 懒汉 静态内部类
//
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }


    // 懒汉 双重校验锁

//    private volatile static Singleton instance;
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    public synchronized void method() {
        System.out.println("synchronized 代码块");
    }

    public static void main(String[] args) {
        System.out.println("hah");

    }

    // 链表反转递归
    public static ListNode rev(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = rev(next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    // 链表反转头插
    public static ListNode revHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
