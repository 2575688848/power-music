package com.ytp.music.guava;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

/**
 * @author pinge
 */
public class ShellTest {

    public static ExecutorService taskPool = new ThreadPoolExecutor(30, 80,
            10L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactoryBuilder().build());

    public static void main(String[] args) {
        try {
            String s = "didii";
            // String path = "echo 哈哈" + "\\>" + "/Users/pinge/Desktop/testshell.sh";
            String path = "mv /Users/pinge/Desktop/testshell.sh /Users/pinge/Desktop/testshell123.sh";
            // String[] params = new String[] { "/bin/bash", "-c", "ansible localhost -m shell -a 'java -jar /Users/ytp/ideaProjects/oxp-service/target/oxp.jar'"};
            String a = "ansible localhost -m script -a '/Users/pinge/Desktop/bash-project/flume-deploy.sh install'";
            taskPool.submit(new MyTask(a));taskPool.submit(new MyTask(a));
            System.out.println("啊哈哈");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
