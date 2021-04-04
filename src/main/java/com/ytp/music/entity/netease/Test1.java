package com.ytp.music.entity.netease;

import com.google.inject.internal.asm.$ByteVector;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
public class Test1 {

//    public static void main(String[] args) {
//        Test1 t = new Test1();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                synchronized (this) {
//                    System.out.println("t1 start");
//                    try {
//                        System.out.println("jajja" + this.getClass());
//                        System.out.println(Test1.class);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("t1 end");
//                }
//            }
//        };
//        System.out.println();
//        runnable.run();
////        Thread t1 = new Thread(runnable);
//        System.out.println("哈哈哈" + t);
////        t1.start();
//    }

    public static void main(String[] args) throws Exception {
        CountDownLatch count = new CountDownLatch(2);
        System.out.println("");
    }
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}


