package com.ytp.music.dao;

import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.SongSortDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface LocalMusicDao {

    /**
     * 添加
     * @param localMusicDO
     * @return
     */
    Boolean add(LocalMusicDO localMusicDO);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 获得所有
     * @param folderId
     * @return
     */
    List<LocalMusicDO> getAll(Integer folderId);


    /**
     * 通过songId获取歌曲id
     * @param songId
     * @return
     */
    Integer getSongIdBySongId(String songId);

    /**
     * 获取一个song
     * @param id
     * @return
     */
    LocalMusicDO getOneSong(Integer id);

    /**
     * 获取所有的分类
     * @return
     */
    List<SongSortDO> getAllSort();

    /**
     * updateSongPlayCount
     * @param id
     * @return
     */
    Boolean updateSongPlayCount(Integer id);

    /**
     * 获取
     * @param time
     * @param id
     * @return
     */
    List<LocalMusicDO> getByTime(String time, Integer id);

    /**
     * 获取
     * @param userId
     * @return
     */
    List<LocalMusicDO> getByUserId(Integer userId);

}
