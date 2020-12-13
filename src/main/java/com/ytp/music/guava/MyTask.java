package com.ytp.music.guava;

import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author pinge
 */
public class MyTask implements Runnable {

    private final String script;

    public MyTask(String script) {
        this.script = script;
    }

    @Override
    public void run() {
        try {
            String[] params = new String[]{"/bin/bash", "-c", script};
            // Process ps = Runtime.getRuntime().exec(params);
            new ProcessExecutor().command("ansible", "localhost", "-m", "script", "-a", "/Users/pinge/Desktop/bash-project/flume-deploy.sh install")
                    .redirectOutput(new LogOutputStream() {
                        @Override
                        protected void processLine(String line) {
                            System.out.println(line);
                        }
                    })
                    .execute();
//            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), StandardCharsets.UTF_8));
//            BufferedReader brError = new BufferedReader(new InputStreamReader(ps.getErrorStream(), StandardCharsets.UTF_8));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null || (line = brError.readLine()) != null) {
//                sb.append(line).append("\n");
//                System.out.println(line);
//            }
//            String result = sb.toString();
//            // System.out.println(result);
            System.out.println("jajjaj");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
