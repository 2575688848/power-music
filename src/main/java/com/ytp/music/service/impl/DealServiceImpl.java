package com.ytp.music.service.impl;

import com.ytp.music.base.Result;
import com.ytp.music.base.UrlConstant;
import com.ytp.music.constant.ProvinceConstant;
import com.ytp.music.entity.MusicVideoDO;
import com.ytp.music.entity.MusicVideoSimpleDO;
import com.ytp.music.entity.SongDO;
import com.ytp.music.entity.UserDO;
import com.ytp.music.service.IDealService;
import com.ytp.music.service.IMusicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ytp
 */
@Service("dealService")
@Transactional(rollbackFor = Exception.class)
public class DealServiceImpl implements IDealService {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private IMusicService musicService;

    @Override
    public List<MusicVideoSimpleDO> dealMusicVideo(List<MusicVideoDO> musicVideos) {
        List<MusicVideoSimpleDO> musicVideoSimpleDOS = new ArrayList<>();
        for (MusicVideoDO musicVideoDO : musicVideos) {
            Result<MusicVideoSimpleDO> result = musicService.getMusicVideo(musicVideoDO.getV_id());
            result.getData().setPlayCount(musicVideoDO.getPlay_count().toString());
            result.getData().setPublictime(musicVideoDO.getPublish_date());
            result.getData().setSinger(musicVideoDO.getSinger_name());
            musicVideoSimpleDOS.add(result.getData());
        }
        return musicVideoSimpleDOS;
    }

    @Override
    public void dealMusicUrl(List<SongDO> songDOS) {
        for (SongDO songDO : songDOS) {
            songDO.setUrl(UrlConstant.QQ_MUSIC_URL + songDO.getId());
        }
    }

    @Override
    public void dealProvinceAndBirthday(List<UserDO> userDOS) {
        for (UserDO userDO : userDOS) {
            userDO.setAddress(ProvinceConstant.getValue(userDO.getProvince()));
            if (userDO.getBirthday() < 0) {
                userDO.setDate("未设置");
            } else {
                userDO.setDate(SDF.format(new Date(userDO.getBirthday())));
            }
        }
    }
}
