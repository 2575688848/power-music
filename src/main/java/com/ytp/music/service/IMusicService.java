package com.ytp.music.service;

import com.ytp.music.base.Result;
import com.ytp.music.entity.*;

import java.util.List;

/**
 * @author ytp
 */
public interface IMusicService {

    /**
     * 获取歌单列表
     *
     * @param id 歌单id
     * @return 歌单列表
     */
    Result<SongListDO> getSongList(String id);


    /**
     * 搜索歌曲，mv
     *
     * @param s
     * @param type
     * @param limit
     * @param offset
     * @return
     */
    Result getResult(String s, String type, Integer limit, Integer offset);

    /**
     * 获取歌曲详细信息
     *
     * @param id
     * @return
     */
    Result<SongDO> getDetailMusic(String id);

    /**
     * 获取mv
     *
     * @param id
     * @return
     */
    Result<MusicVideoSimpleDO> getMusicVideo(String id);

    /**
     * 获取歌单分类
     *
     * @return
     */
    Result<List<SongListCategoryDO>> getSongListCategory();

    /**
     * 获取分类的歌单
     *
     * @param categoryId
     * @return
     */
    Result<List<SongListSimpleDO>> getSongsOfCategory(Integer categoryId);

    /**
     * 获取热门mv
     *
     * @param limit
     * @param offset
     * @return
     */
    Result<List<MusicVideoSimpleDO>> getHotMusicVideoList(Integer limit, Integer offset);


    /**
     * 获取用户列表
     * @param s
     * @param type
     * @param limit
     * @param offset
     * @return
     */
    Result<ResultUser> getUser(String s, String type, Integer limit, Integer offset);

    /**
     * 获取用户歌单列表
     * @param uid
     * @return
     */
    Result<List<NetEaseSongListDO>> getNetEaseSongList(Long uid);

    /**
     * 获取用户动态信息
     * @param id
     * @return
     */
    Result<String> getUserDynamicDO(Long id);

    /**
     * 获取歌曲的评论
     * @param id
     * @return
     */
    Result<String> getCommentsOfSong(Long id);
}
