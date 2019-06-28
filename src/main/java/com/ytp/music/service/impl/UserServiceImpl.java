package com.ytp.music.service.impl;

import com.ytp.music.dao.LocalMusicDao;
import com.ytp.music.dao.NetEaseDao;
import com.ytp.music.dao.SongFolderDao;
import com.ytp.music.dao.UserDao;
import com.ytp.music.entity.local.AnalysisDO;
import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.SongFolderDO;
import com.ytp.music.entity.local.UserDO;
import com.ytp.music.service.IUserService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ytp
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;
    @Resource
    private NetEaseDao netEaseDao;
    @Resource
    private LocalMusicDao localMusicDao;
    @Resource
    private SongFolderDao songFolderDao;

    private static final String IMAGE_URL = "/src/assets/images/person/head1.ico";

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public UserDO register(UserDO userDO) {
        userDO.setUrl(IMAGE_URL);
        userDao.register(userDO);
        return userDO;
    }

    @Override
    public UserDO login(UserDO userDO) {
        UserDO user = userDao.getUser(userDO.getUsername(), userDO.getPassword());
        return user;
    }

    @Override
    public Boolean update(UserDO userDO) {
        return userDao.update(userDO);
    }

    @Override
    public Boolean addNetEaseUser(com.ytp.music.entity.UserDO userDO, Integer id) {
        UserDO userDO1 = userDao.getUserById(id);
        if (userDO1.getEaseId() != null && userDO1.getEaseId().equals(userDO.getUserId())) {
            return true;
        }
        UserDO user = new UserDO();
        user.setId(id);
        user.setEaseId(userDO.getUserId());
        userDao.update(user);
        return netEaseDao.addUser(userDO);
    }

    @Override
    public com.ytp.music.entity.UserDO getNetUser(Long id) {
        return netEaseDao.getUser(id);
    }

    @Override
    public AnalysisDO getAnalysis(Integer id) {
        AnalysisDO analysisDO = new AnalysisDO();
        Date date = new Date();
        String timeString = DateFormatUtils.format(date, "yyyy-MM");
        String time = DateFormatUtils.format(date, "yyyy年MM月");

        List<LocalMusicDO> musics = localMusicDao.getByTime(timeString,id);

        if (CollectionUtils.isEmpty(musics)) {
            analysisDO.setAnalysis1("这个月你还没有听歌！");
            analysisDO.setAnalysis2("这个月你还没有听歌！");
            analysisDO.setAnalysis3("这个月你还没有听歌！");
            analysisDO.setDate(time);
            analysisDO.setSongs(new ArrayList<>());
            return analysisDO;
        }

        StringBuilder analysis1 = new StringBuilder();
        analysis1.append("这个月，你一共听了 ").append(musics.size()).append(" 首音乐，累计播放量达 ");
        int playCount = 0;
        for (LocalMusicDO musicDO : musics) {
            playCount += musicDO.getPlayCount();
        }
        analysis1.append(playCount).append(" 次。按照平均每首歌4分钟来算，你相当于不眠不休的连续听了 ");
        int plays = playCount * 4 / 60 + 1;
        analysis1.append(plays).append(" 小时的歌。在这个月你听的所有歌曲里，");

        List<SongFolderDO> songFolderDOS = songFolderDao.getByTime(timeString, id);
        List<SongFolderDO> songFolderDOSAll = songFolderDao.getAllFolder(id);

         analysis1.append(songFolderDOS.get(0).getFolderName()).append(" 歌单是你最喜欢的。它里面");
        if (songFolderDOS.get(0).getSongCount() <= 5) {
            analysis1.append("虽然只收录了 ").append(songFolderDOS.get(0).getSongCount()).append(" 首歌曲，播放量却高达 ").append(songFolderDOS.get(0).getPlayCount())
                    .append(" 次，");
        } else {
            analysis1.append("收录了 ").append(songFolderDOS.get(0).getSongCount()).append(" 首歌曲，播放量达 ").append(songFolderDOS.get(0).getPlayCount())
                    .append(" 次，");
        }
        analysis1.append("你心里面最喜欢的那几首歌在这个歌单吗？");
        SongFolderDO otherSongFolder = songFolderDOSAll.get(0);
        try {
            Date date1 = DateUtils.parseDate(timeString, "yyyy-MM");
            if (otherSongFolder.getGmtModify().getTime() < date1.getTime()) {
                String time1 = DateFormatUtils.format(otherSongFolder.getGmtCreate(), "yyyy年MM月dd日");
                analysis1.append("其中在 ").append(time1).append(" 创建的 ").append(otherSongFolder.getFolderName()).append(" 歌单是你曾经最喜欢的，这个月是不是已经把它遗忘了。");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        analysisDO.setAnalysis1(analysis1.toString());
        analysisDO.setAnalysis2(dealAnalysis2(musics));
        analysisDO.setAnalysis3(dealAnalysis3(musics, id));
        analysisDO.setDate(time);
        if (musics.size() > 10) {
            analysisDO.setSongs(musics.subList(0, 9));
        } else {
            analysisDO.setSongs(musics);
        }
        return analysisDO;
    }

    private String dealAnalysis2(List<LocalMusicDO> musics) {
        StringBuilder analysis2 = new StringBuilder();
        Map<String, Integer> songSortMap = new HashMap<>(16);
        int max = 2;
        String name = musics.get(0).getSongType();
        for (LocalMusicDO localMusicDO : musics) {
            if (songSortMap.containsKey(localMusicDO.getSongType())) {
                songSortMap.put(localMusicDO.getSongType(), songSortMap.get(localMusicDO.getSongType())+1);
                if (songSortMap.get(localMusicDO.getSongType()) >=  max) {
                    name = localMusicDO.getSongType();
                    max = songSortMap.get(localMusicDO.getSongType());
                }
            } else {
                songSortMap.put(localMusicDO.getSongType(), 1);
            }
        }
        analysis2.append("你这个月听的最多的是 ").append(name).append("。");
        if ("伤感歌曲".equals(name)) {
            analysis2.append("看来，这个月你一定是遇到了一些不好的事情，但不要灰心，所有你跨过的坎，终究使你更强大。加油！");
        }
        if ("欢快歌曲".equals(name)) {
            analysis2.append("看来，这个月你的精神状态很好啊，表现不错，继续保持！");
        }
        if ("励志歌曲".equals(name)) {
            analysis2.append("有觉悟，有激情是你这个月的常态，坚持下去，你会发现一个更为强大的自己");
        }
        return analysis2.toString();
    }

    private String dealAnalysis3(List<LocalMusicDO> musics, Integer id) {
        StringBuilder analysis3 = new StringBuilder();
        analysis3.append("在这这个月你听的歌曲中，");
        if (musics.size() == 1) {
            analysis3.append(musics.get(0).getName()).append(" 播放过 ").append(musics.get(0).getPlayCount()).append(" 次，是你这个月最常听的一首音乐。");
        }
        if (musics.size() == 2) {
            analysis3.append(musics.get(0).getName()).append(" 播放过 ").append(musics.get(0).getPlayCount()).append(" 次，")
                    .append(musics.get(1).getName()).append(" 播放过 ").append(musics.get(1).getPlayCount()).append(" 次，是你这个月最常听的两首音乐。");
        }
        if (musics.size() >= 3) {
            analysis3.append(musics.get(0).getName()).append(" 播放过 ").append(musics.get(0).getPlayCount()).append(" 次，")
                    .append(musics.get(1).getName()).append(" 播放过 ").append(musics.get(1).getPlayCount()).append(" 次，")
                    .append(musics.get(2).getName()).append(" 播放过 ").append(musics.get(2).getPlayCount()).append(" 次，是你这个月最常听的三首音乐。");
        }
        List<LocalMusicDO> allMusic = localMusicDao.getByUserId(id);
        LocalMusicDO localMusicDO = allMusic.get(0);
        String timeString = DateFormatUtils.format(new Date(), "yyyy-MM");
        try {
            Date date = DateUtils.parseDate(timeString, "yyyy-MM");
            if (localMusicDO.getGmtModify().getTime() < date.getTime()) {
                String time1 = DateFormatUtils.format(localMusicDO.getGmtCreate(), "yyyy年MM月dd日");
                analysis3.append("但是这首在 ").append(time1).append(" 被你收录到歌单的 ").append(localMusicDO.getName()).append(" 是你曾经最喜欢的音乐，这个月你好像已经把它忘记了。");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return analysis3.toString();
    }
}































