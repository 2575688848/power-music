package com.ytp.music.time;

import org.springframework.util.StopWatch;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author pinge
 */
public class TestTimer {

    public static void main(String[] args) throws Exception{
//        for (int i = 0; i < 1; ++i) {
//            Timer timer = new Timer("123");
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println(" run 1 ");
//                }
//            }, 2000, 3000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println(" run 2 ");
//                }
//            }, 1000, 2000);
//        }

        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(1000);
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());

        System.out.println("jssj" + null);

        int x = 12 + 12;
        assert(x == 42);
    }

    public void test () {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    }
}
