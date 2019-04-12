package com.ytp.music.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * @author ytp
 * @date 2018/12/19
 */
@Slf4j
@Component
public class CommonUtils {

    private static final int CONNECT_TIMEOUT = 10000;
    private static final int SOCKET_TIMEOUT = 6000;
    private static final String KEY = "579621905";

    /**
     * 获取返回结果字符串
     * @param params 请求参数
     * @param url    url
     * @return       获得的内容字符串
     */
    public static String getResponseString(Map<String, Object> params, String url) {
        URIBuilder uriBuilder;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            uriBuilder = new URIBuilder(url);
            // 固定参数key
            uriBuilder.setParameter("key", KEY);
            if (params != null) {
                Set<Map.Entry<String, Object>> entrySet = params.entrySet();
                for (Map.Entry<String, Object> entry : entrySet) {
                    if (entry.getValue() != null) {
                        uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                return EntityUtils.toString(httpEntity, "utf-8");
            } else {
                log.info("访问音乐接口失败");
                throw new RuntimeException("数据失联了，攻城狮正在紧急搜索中……，请重新刷新页面试试");
            }
        } catch (Exception e) {
            log.error("创建链接失败");
            log.error("访问url :{}", url);
            throw new RuntimeException("数据失联了，攻城狮正在紧急搜索中……，请重新刷新页面试试");
        } finally {
            closeConnect(httpClient, response);
        }
    }

    private static void closeConnect(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
            if (httpResponse != null) {
                httpResponse.close();
            }
        } catch (Exception e) {
            log.error("关闭网络连接资源失败");
            throw new RuntimeException("数据失联了，攻城狮正在紧急搜索中……，请重新刷新页面试试");
        }
    }
}
