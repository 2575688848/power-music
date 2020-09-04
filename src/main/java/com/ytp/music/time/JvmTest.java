package com.ytp.music.time;

/**
 * @author pinge
 */
public class JvmTest {

    public static void main(String[] args) throws Exception{
        System.out.println("。。。。程序开始。。。。");
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        Thread.sleep(100000);
        System.out.println("。。。。程序结束。。。。");
    }

    public static void alloc() {
        Point point = new Point(1, 1);
    }

    static class Point {
        int x;
        int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
