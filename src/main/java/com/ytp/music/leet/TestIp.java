package com.ytp.music.leet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestIp {

    private static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    int getIpCount(String ip) {
        if (ipMap.containsKey(ip)) {
            synchronized (TestIp.class) {
                ipMap.put(ip, ipMap.get(ip) + 1);
            }
        } else {
            synchronized (TestIp.class) {
                if (!ipMap.containsKey(ip)) {
                    ipMap.put(ip, 1);
                } else {
                    ipMap.put(ip, ipMap.get(ip) + 1);
                }
            }
        }
        return ipMap.get(ip);
    }
}
