package com.ytp.music.leet;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pinge
 */
public class Test {
    private Lock lock = new ReentrantLock();

    public synchronized void method1() {
        method2();
    }

    public synchronized static void method2() {
        Class a = Test.class;
        System.out.println(a.getModifiers());
    }

    public static void main(String[] args) {
//        Test test = new Test();
//        MyThread thread1 = new MyThread(test, "thread1");
//        MyThread thread2 = new MyThread(test, "thread2");
//        thread1.start();
//        thread2.start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("哈哈哈");
//        thread2.interrupt();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.offer(1);
        linkedList.offer(2);
        linkedList.offer(3);
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(2, 3);
        System.out.println(list);

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine();
        System.out.println(a);

        short s1 = 1;
        s1 += 1;
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
                //插入数据
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = 0, sum = 0;
        char key = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
            sum += entry.getValue();
        }
        if ((max - (sum - max)) >= 2) {
            return "";
        }
        int i = 0;
        char[] result = new char[chars.length];
        for (char c : chars) {
            if (c != key) {
                if (max != 0) {
                    result[i++] = key;
                    if (i < chars.length) {
                        result[i++] = c;
                    }
                    max--;
                } else {
                    result[i++] = c;
                }
            }
        }
        if (max == 1) {
            result[i] = key;
        }
        return new String(result);
    }

    public int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length) {
            return new int[0][0];
        }
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][]);
    }


}

class MyThread extends Thread {
    private Test test = null;

    public MyThread(Test test, String name) {
        super(name);
        this.test = test;
    }

    @Override
    public void run() {

        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}