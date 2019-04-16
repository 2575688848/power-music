package com.ytp.music.netease.core;


import com.ytp.music.netease.netease.Api;
import com.ytp.music.netease.netease.UrlParamPair;
import com.ytp.music.netease.secret.JSSecret;
import org.jsoup.Connection;
import org.jsoup.Jsoup;


public class Demo {
    public static void main(String[] args) {
        try {
            String uid = "395631192";
            UrlParamPair upp = Api.getPlaylistOfUser(uid);
            System.out.println("UrlParamPair:"+upp.toString());
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:"+req_str);
            JSSecret.getDatas(req_str);

            Connection.Response
                    response =
                    //获取用户歌单
                    //Jsoup.connect("http://music.163.com/weapi/user/playlist?csrf_token=")
                    //获取用户评论
                    Jsoup.connect("https://music.163.com/weapi/event/get/395631192?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}