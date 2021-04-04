package com.ytp.music.leet;

public class Test319 {
    private static class StaticInner{ }//静态内部类

    private class Inner{}//成员内部类

    public void outerFunction1(){
        class PartInner3{}//局部内部类3
    }
    public void outerFunction2(){
        class PartInner1{}//局部内部类1
        class PartInner2{}//局部内部类2
    }

    public static void outerFunction3() {
        int a = 0;
        class PartInner4 {
            private int a = 0;

            public void a() {
                System.out.println(a);
            }
        }
    }

    public Thread thread1 = new Thread(new Runnable() {//匿名内部类1
        @Override
        public void run() {
        }
    }, "thread1");
    public Thread thread2 = new Thread(new Runnable() {//匿名内部类2
        @Override
        public void run() {
        }
    }, "thread2");
    public Thread thread3 = new Thread(()->{//匿名内部类（使用lambda表达式）

    },"thread3");

}