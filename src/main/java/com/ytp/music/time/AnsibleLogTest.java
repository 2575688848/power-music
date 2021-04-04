package com.ytp.music.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class AnsibleLogTest {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/pinge/Desktop/a.log");
        BufferedReader buf = new BufferedReader(new FileReader(file));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = buf.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String result = sb.toString();
        try {
            String[] list = result.split("LOG_SPLIT");
            List<AnsibleLog> ansibleLogs = new ArrayList<>();
            Arrays.stream(list).forEach(log -> {
                JSONObject info = JSON.parseObject(log);
                JSONArray plays = info.getJSONArray("plays");
                JSONArray tasks = plays.getJSONObject(0).getJSONArray("tasks");
                Map<String, Object> hosts = tasks.getJSONObject(0).getJSONObject("hosts");
                Set<String> ips = hosts.keySet();
                ips.forEach(ip -> {
                    AnsibleLog ansibleLog = new AnsibleLog();
                    JSONObject host = (JSONObject) hosts.get(ip);
                    ansibleLog.setIp(ip);
                    if (host.getBoolean("changed")) {
                        ansibleLog.setStatus(host.getInteger("rc") == 0);
                        ansibleLog.setLogList(host.getJSONArray("stdout_lines").toJavaList(String.class));
                        ansibleLog.setOtherErrorLogList(host.getJSONArray("stderr_lines").toJavaList(String.class));
                    } else {
                        ansibleLog.setStatus(false);
                        ansibleLog.setLogList(Collections.singletonList(host.getString("msg")));
                    }
                    ansibleLogs.add(ansibleLog);
                });
            });
            System.out.println(JSON.toJSONString(ansibleLogs));
        } catch (Exception e) {
        }
        System.out.println(result);
    }
}
