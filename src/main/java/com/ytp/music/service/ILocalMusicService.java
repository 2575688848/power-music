package com.ytp.music.service;

import com.sun.corba.se.spi.ior.Identifiable;
import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.MusicVideoDO;
import com.ytp.music.entity.local.SongFolderDO;
import com.ytp.music.entity.local.SongSortDO;

import java.util.List;

/**
 * @author ytp
 */
public interface ILocalMusicService {

    static void a() {
        System.out.println("阿计算机技术");
    }

    int A = 0;
    /**
     * 添加歌单
     * @param songFolderDO
     * @return
     */
    Boolean addFolder(SongFolderDO songFolderDO);

    /**
     * 更新文件夹
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
     * deleteSong
     * @param id
     * @return
     */
    Boolean deleteSong(Integer id);

    /**
     * 获得所有歌单
     * @return
     */
    List<SongFolderDO> getAllFolder(Integer userId);

    /**
     * 获得所有
     * @param folderId
     * @return
     */
    List<LocalMusicDO> getAll(Integer folderId);

    /**
     * 获得所有
     * @param userId
     * @return
     */
    List<MusicVideoDO> getAllMusicVideo(Integer userId);

    /**
     * 获取所有的分类
     * @return
     */
    List<SongSortDO> getAllSort();

    /**
     * 添加歌曲
     * @param localMusicDO
     * @return
     */
    Boolean addSong(LocalMusicDO localMusicDO);

    /**
     * updateSongPlayCount
     * @param id
     * @return
     */
    Boolean updateSongPlayCount(Integer id);

    /**
     * add
     * @param musicVideoDO
     * @return
     */
    Boolean addMusicVideo(MusicVideoDO musicVideoDO);

    /**
     * delete
     * @param id
     * @return
     */
    Boolean deleteMusicVideo(Integer id);
}
