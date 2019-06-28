package com.ytp.music.service.impl;

import com.ytp.music.dao.LocalMusicDao;
import com.ytp.music.dao.MusicVideoDao;
import com.ytp.music.dao.SongFolderDao;
import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.MusicVideoDO;
import com.ytp.music.entity.local.SongFolderDO;
import com.ytp.music.entity.local.SongSortDO;
import com.ytp.music.service.ILocalMusicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ytp
 */
@Service("localMusicService")
@Transactional(rollbackFor = Exception.class)
public class LocalMusicServiceImpl implements ILocalMusicService {

    @Resource
    private SongFolderDao songFolderDao;
    @Resource
    private LocalMusicDao localMusicDao;
    @Resource
    private MusicVideoDao musicVideoDao;


    @Override
    public Boolean addFolder(SongFolderDO songFolderDO) {
        return songFolderDao.addFolder(songFolderDO);
    }

    @Override
    public Boolean updateFolder(String folderName, Integer id, Integer type) {
        return songFolderDao.updateFolder(folderName, id, type);
    }

    @Override
    public Boolean deleteFolder(Integer id) {
        return songFolderDao.deleteFolder(id);
    }

    @Override
    public Boolean deleteSong(Integer id) {
        LocalMusicDO localMusicDO = localMusicDao.getOneSong(id);
        songFolderDao.updateFolder("", localMusicDO.getFolderId(), -1);
        return localMusicDao.delete(id);
    }

    @Override
    public List<SongFolderDO> getAllFolder(Integer userId) {
        return songFolderDao.getAllFolder(userId);
    }

    @Override
    public List<LocalMusicDO> getAll(Integer folderId) {
        return localMusicDao.getAll(folderId);
    }

    @Override
    public List<MusicVideoDO> getAllMusicVideo(Integer userId) {
        return musicVideoDao.getAll(userId);
    }

    @Override
    public List<SongSortDO> getAllSort() {
        return localMusicDao.getAllSort();
    }

    @Override
    public Boolean addSong(LocalMusicDO localMusicDO) {
        Integer id = localMusicDao.getSongIdBySongId(localMusicDO.getSongId());
        if (id != null) {
            return false;
        }
        songFolderDao.updateFolder("", localMusicDO.getFolderId(), 1);
        return localMusicDao.add(localMusicDO);
    }

    @Override
    public Boolean updateSongPlayCount(Integer id) {
        return localMusicDao.updateSongPlayCount(id);
    }

    @Override
    public Boolean addMusicVideo(MusicVideoDO musicVideoDO) {
        MusicVideoDO musicVideoDO1 = musicVideoDao.getOneMusicVideo(musicVideoDO.getUrl());
        if (musicVideoDO1 != null) {
            return false;
        }
        return musicVideoDao.add(musicVideoDO);
    }

    @Override
    public Boolean deleteMusicVideo(Integer id) {
        return musicVideoDao.delete(id);
    }
}
