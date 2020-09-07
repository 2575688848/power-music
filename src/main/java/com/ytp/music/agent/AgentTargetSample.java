package com.ytp.music.agent;

/**
 * @author pinge
 */
public class AgentTargetSample {

    public void sayHello(String name) {
        System.out.println(String.format("%s say hello!", name));
    }

    public static void main(String[] args) throws Exception {
        AgentTargetSample sample = new AgentTargetSample();
        for (; ; ) {
            Thread.sleep(2000);
            sample.sayHello(Thread.currentThread().getName());
        }
    }
}
