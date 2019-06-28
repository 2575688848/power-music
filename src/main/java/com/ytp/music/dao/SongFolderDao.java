package com.ytp.music.dao;

import com.ytp.music.entity.local.SongFolderDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface SongFolderDao {

    /**
     * 添加歌单
     * @param songFolderDO
     * @return
     */
    Boolean addFolder(SongFolderDO songFolderDO);

    /**
     * 更新文件夹
     * @param folderName
     * @param id
     * @param type
     * @return
     */
    Boolean updateFolder(String folderName, Integer id, Integer type);

    /**
     * 删除歌单
     * @param id
     * @return
     */
    Boolean deleteFolder(Integer id);

    /**
     * 获得所有歌单
     * @param userId
     * @return
     */
    List<SongFolderDO> getAllFolder(Integer userId);

    /**
     * get文件夹
     * @param time
     * @param id
     * @return
     */
    List<SongFolderDO> getByTime(String time, Integer id);
}
