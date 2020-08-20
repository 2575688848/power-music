package com.ytp.music.time;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author pinge
 */
public class TestTimer {

    public static void main(String[] args) {
        for (int i = 0; i < 1; ++i) {
            Timer timer = new Timer("123");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" run 1 ");
                }
            }, 2000, 3000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(" run 2 ");
                }
            }, 1000, 2000);
        }
    }

    public void test () {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    }
}
