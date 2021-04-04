package com.ytp.music.time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author pinge
 */
public class AnsibleTest {

    public static void main(String[] args) throws Exception {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        String[] params = new String[]{"/bin/bash", "-c", "ansible localhost -m script -a '/Users/pinge/Desktop/bash-project/flume-deploy.sh install'" + " >> /Users/pinge/Desktop/log.txt"};
        Runtime runtime = Runtime.getRuntime();
        Process ps = runtime.exec(params);
        System.out.println("哈哈哈，开始-------");
        ps.waitFor(7, TimeUnit.MINUTES);
        ps.destroy();
        Process ps2 = runtime.exec(new String[]{"/bin/bash", "-c", "scp pinge@localhost:/Users/pinge/Desktop/log.txt /Users/pinge/Desktop/flume/"});
        ps2.waitFor(3, TimeUnit.MINUTES);

        int exitCode2 = ps2.exitValue();
        File file = new File("/Users/pinge/Desktop/log.txt");
        BufferedReader buf = new BufferedReader(new FileReader(file));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }

        Field f = ps.getClass().getDeclaredField("stdout");
        f.setAccessible(true);

    }
}
