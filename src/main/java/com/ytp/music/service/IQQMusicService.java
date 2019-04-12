package com.ytp.music.service;

import com.ytp.music.base.Result;
import com.ytp.music.entity.SongListDO;

/**
 * @author ytp
 */
public interface IQQMusicService {

    /**
     * 获取歌单列表
     *
     * @param id 歌单id
     * @return 歌单列表
     */
    Result<SongListDO> getSongList(String id);


}
