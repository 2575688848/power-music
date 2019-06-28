package com.ytp.music.service;

import com.ytp.music.entity.MusicVideoDO;
import com.ytp.music.entity.MusicVideoSimpleDO;
import com.ytp.music.entity.SongDO;
import com.ytp.music.entity.UserDO;

import java.util.List;

/**
 * @author ytp
 */
public interface IDealService {

    /**
     * 处理mv的缺少信息
     * @param musicVideos
     * @return
     */
    List<MusicVideoSimpleDO> dealMusicVideo(List<MusicVideoDO> musicVideos);

    /**
     * 解决返回的歌曲url不能播放问题
     * @param songDOS
     */
    void dealMusicUrl(List<SongDO> songDOS);

    /**
     * 处理省份和生日
     * @param userDOS
     */
    void dealProvinceAndBirthday(List<UserDO> userDOS);
}
