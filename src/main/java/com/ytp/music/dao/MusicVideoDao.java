package com.ytp.music.dao;

import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.MusicVideoDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface MusicVideoDao {

    /**
     * 添加
     * @param musicVideoDO
     * @return
     */
    Boolean add(MusicVideoDO musicVideoDO);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 获得所有
     * @param userId
     * @return
     */
    List<MusicVideoDO> getAll(Integer userId);

    /**
     * getOne
     * @param url
     * @return
     */
    MusicVideoDO getOneMusicVideo(String url);
}
