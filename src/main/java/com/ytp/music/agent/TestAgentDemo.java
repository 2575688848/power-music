package com.ytp.music.agent;

/**
 * @author pinge
 */
public class TestAgentDemo {

    public static void main(String... args) {
        testAgent();

        testAgent1("1", "2");
    }

    public static void testAgent() {
        System.out.println("test agent say hello");
    }

    public static void testAgent1(String one, String two) {
        System.out.println("test agent say hello" + one + two);
    }
}
