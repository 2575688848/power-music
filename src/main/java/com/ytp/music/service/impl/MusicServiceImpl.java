package com.ytp.music.service.impl;

import com.ytp.music.base.ResponseDO;
import com.ytp.music.base.Result;
import com.ytp.music.base.UrlConstant;
import com.ytp.music.entity.*;
import com.ytp.music.entity.netease.CommentResultDO;
import com.ytp.music.entity.netease.UserDynamicDO;
import com.ytp.music.netease.netease.Api;
import com.ytp.music.netease.netease.UrlParamPair;
import com.ytp.music.netease.secret.JSSecret;
import com.ytp.music.service.IMusicService;
import com.ytp.music.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ytp
 */
@Service("qqMusicService")
@Slf4j
public class MusicServiceImpl implements IMusicService {

    private static final String SONG = "song";
    private static final String MV = "mv";

    @Override
    public Result<SongListDO> getSongList(String id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("id", id);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_SONGLIST_URL);
        ResponseDO<SongListDO> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<SongListDO>>() {
        });
        if (responseDO == null) {
            log.error("获取音乐列表信息失败");
            return Result.fail("获取音乐列表信息失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result getResult(String s, String type, Integer limit, Integer offset) {
        Map<String, Object> params = new HashMap<>(6);
        params.put("s", s);
        params.put("type", type);
        params.put("limit", limit);
        params.put("offset", offset);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_SEARCH_URL);
        ResponseDO responseDO = new ResponseDO();
        if (SONG.equals(type)) {
            responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<SongDO>>>() {
            });

        }
        if (MV.equals(type)) {
            responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<MusicVideoDO>>>() {
            });
        }
        if (responseDO == null) {
            log.error("查询失败");
            return Result.fail("查询失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<SongDO> getDetailMusic(String id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("id", id);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_DETAIL_SONG_URL);
        ResponseDO<SongDO> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<SongDO>>() {
        });
        if (responseDO == null) {
            log.error("获取音乐详细信息失败");
            return Result.fail("获取音乐详细信息失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<MusicVideoSimpleDO> getMusicVideo(String id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("id", id);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_MUSIC_VIDEO_URL);
        ResponseDO<MusicVideoSimpleDO> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<MusicVideoSimpleDO>>() {
        });
        if (responseDO == null) {
            log.error("获取mv详细信息失败");
            return Result.fail("获取mv详细信息失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<List<SongListCategoryDO>> getSongListCategory() {
        Map<String, Object> params = new HashMap<>(2);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_SONG_LIST_CATEGORY_URL);
        ResponseDO<List<SongListCategoryDO>> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<SongListCategoryDO>>>() {
        });
        if (responseDO == null) {
            log.error("获取歌单分类失败");
            return Result.fail("获取歌单分类失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<List<SongListSimpleDO>> getSongsOfCategory(Integer categoryId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("categoryId", categoryId);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_HOT_SONG_LIST_URL);
        ResponseDO<List<SongListSimpleDO>> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<SongListSimpleDO>>>() {
        });
        if (responseDO == null) {
            log.error("获取分类的歌曲失败");
            return Result.fail("获取分类的歌曲失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<List<MusicVideoSimpleDO>> getHotMusicVideoList(Integer limit, Integer offset) {
        Map<String, Object> params = new HashMap<>(5);
        params.put("limit", limit);
        params.put("offset", offset);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_HOT_MV_URL);
        ResponseDO<List<MusicVideoSimpleDO>> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<MusicVideoSimpleDO>>>() {
        });
        if (responseDO == null) {
            log.error("获取分类的歌曲失败");
            return Result.fail("获取分类的歌曲失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<ResultUser> getUser(String s, String type, Integer limit, Integer offset) {
        Map<String, Object> params = new HashMap<>(6);
        params.put("s", s);
        params.put("type", type);
        params.put("limit", limit);
        params.put("offset", offset);
        String content = CommonUtils.getResponseString(params, UrlConstant.NT_SEARCH_URL);
        ResponseDO<ResultUser> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<ResultUser>>() {
        });
        if (responseDO == null) {
            log.error("获查询网易云信息失败");
            return Result.fail("获查询网易云信息失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<List<NetEaseSongListDO>> getNetEaseSongList(Long uid) {
        Map<String, Object> params = new HashMap<>(5);
        params.put("uid", uid);
        String content = CommonUtils.getResponseString(params, UrlConstant.NT_USER_SONG_LIST_URL);
        ResponseDO<List<NetEaseSongListDO>> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<List<NetEaseSongListDO>>>() {
        });
        if (responseDO == null) {
            log.error("获取用户歌单失败");
            return Result.fail("获取用户歌单失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }

    @Override
    public Result<String> getUserDynamicDO(Long id) {
        try {
            String uid = String.valueOf(id);
            UrlParamPair upp = Api.getPlaylistOfUser(uid);
            String reqStr = upp.getParas().toJSONString();
            JSSecret.getDatas(reqStr);
            Connection.Response
                    response =
                    //获取用户评论
                    Jsoup.connect("https://music.163.com/weapi/event/get/" + uid + "?csrf_token=")
                            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                            .header("Accept", "*/*")
                            .header("Cache-Control", "no-cache")
                            .header("Connection", "keep-alive")
                            .header("Host", "music.163.com")
                            .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                            .header("DNT", "1")
                            .header("Pragma", "no-cache")
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .data(JSSecret.getDatas(reqStr))
                            .method(Connection.Method.POST)
                            .ignoreContentType(true)
                            .timeout(10000)
                            .execute();
            String content = response.body();
            UserDynamicDO userDynamicDO = JSON.parseObject(content, new TypeReference<UserDynamicDO>() {});
        } catch (Exception e) {
            log.error("获取用户动态失败" + e.getMessage());
            return Result.fail("获取用户动态失败");
        }
        return null;
    }

    @Override
    public Result<String> getCommentsOfSong(Long id) {
        try {
            String musicId = String.valueOf(id);
            UrlParamPair upp = Api.getDetailOfPlaylist(musicId);
            String reqStr = upp.getParas().toJSONString();
            //某个歌的评论
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_"+musicId+"?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(reqStr))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String content = response.body();
            CommentResultDO commentResultDO = JSON.parseObject(content, new TypeReference<CommentResultDO>() {});
        } catch (Exception e) {
            log.error("获取评论失败" + e.getMessage());
            return Result.fail("获取评论失败");
        }
        return null;
    }


}

