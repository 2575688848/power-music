package com.ytp.music.netty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Test {

    byte[] a = new byte[100 * 1024];

    public static void main(String[] args) throws Exception{

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Test s = (Test) context.getBean("test");
//        System.out.println(s.out());

        ArrayList<Test> arrayList = new ArrayList<>();
        while (true) {
            arrayList.add(new Test());
            Thread.sleep(50);
        }

    }

    public static int out() {
        return 1;
    }
}
