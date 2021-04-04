package com.ytp.music.leet;

import com.ytp.music.entity.MusicVideoDO;
import com.ytp.music.entity.MusicVideoSimpleDO;
import com.ytp.music.entity.SongDO;
import com.ytp.music.entity.UserDO;
import com.ytp.music.service.IDealService;
import com.ytp.music.service.ILocalMusicService;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class fileTest {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread.sleep(1000);
        Thread threadB = new Thread(new RunB(lock));
        threadB.start();
        // 没有获取到threadB 的对象锁就 调用wait 方法，会抛出java.lang.IllegalMonitorStateException
        threadB.wait();
        System.out.println("hahahh");
    }

    class A {
        int a = 1;
    }

    class C {
        int c = 2;
    }

    static class RunB implements Runnable {

        private Object lock;

        public RunB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {
                System.out.println("b come");
            }
        }
    }


}

