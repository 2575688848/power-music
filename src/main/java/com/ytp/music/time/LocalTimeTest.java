package com.ytp.music.time;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author pinge
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        try {
            MemcachedClient client = new XMemcachedClient("127.0.0.1",11211);
            String key = "xmemcached";
            System.out.println(client.add(key,0,"x1"));
            System.out.println((String) client.get(key));
            System.out.println("哈哈哈" + client.delete("wwww"));
            System.out.println("哈哈哈" + client.delete(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
