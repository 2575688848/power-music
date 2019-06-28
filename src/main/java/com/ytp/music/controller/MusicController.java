package com.ytp.music.controller;

import com.ytp.music.base.Result;
import com.ytp.music.entity.local.LocalMusicDO;
import com.ytp.music.entity.local.MusicVideoDO;
import com.ytp.music.entity.local.SongFolderDO;
import com.ytp.music.entity.local.UserDO;
import com.ytp.music.service.ILocalMusicService;
import com.ytp.music.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ytp
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/localMusic")
@Api(tags = "local-music", value = "/api/v1/localMusic", description = "本地音乐接口")
public class MusicController {

    @Resource
    private ILocalMusicService localMusicService;

    @ApiOperation("添加歌单")
    @PostMapping("/add")
    public Result add(@RequestBody SongFolderDO songFolderDO) {
        log.info("添加歌单 歌单 :{}",songFolderDO);
        return Result.success(localMusicService.addFolder(songFolderDO));
    }

    @ApiOperation("获得所有歌单")
    @GetMapping("/{userId}")
    public Result get(@PathVariable("userId") Integer userId) {
        log.info("获得所有歌单 用户Id :{}",userId);
        return Result.success(localMusicService.getAllFolder(userId));
    }


    @ApiOperation("编辑歌单")
    @PutMapping("/update")
    public Result update(@RequestParam(value = "folderName", required = false) String folderName, @RequestParam("id") Integer id, @RequestParam("type") Integer type) {
        log.info("编辑歌单 info id :{}",id);
        return Result.success(localMusicService.updateFolder(folderName, id, type));
    }

    @ApiOperation("删除歌单")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        log.info("删除歌单 id :{}",id);
        return Result.success(localMusicService.deleteFolder(id));
    }

    @ApiOperation("删除歌曲")
    @DeleteMapping("/song/{id}")
    public Result deleteSong(@PathVariable("id") Integer id) {
        log.info("删除歌曲 id :{}",id);
        return Result.success(localMusicService.deleteSong(id));
    }

    @ApiOperation("获得歌单的所有音乐")
    @GetMapping("/music/{folderId}")
    public Result getSongs(@PathVariable("folderId") Integer folderId) {
        log.info("获得歌单的所有音乐 歌单Id :{}",folderId);
        return Result.success(localMusicService.getAll(folderId));
    }

    @ApiOperation("获得所有的mv")
    @GetMapping("/musicVideo/{userId}")
    public Result getMusicVideo(@PathVariable("userId") Integer userId) {
        log.info("获得所有的mv 歌单Id :{}",userId);
        return Result.success(localMusicService.getAllMusicVideo(userId));
    }

    @ApiOperation("添加MV")
    @PostMapping("/addMusicVideo")
    public Result addMusicVideo(@RequestBody MusicVideoDO musicVideoDO) {
        log.info("添加MV MV :{}",musicVideoDO);
        boolean flag = localMusicService.addMusicVideo(musicVideoDO);
        if (flag) {
            return Result.success(true);
        } else {
            return Result.fail("此MV已在你的本地MV中");
        }
    }

    @ApiOperation("删除MV")
    @DeleteMapping("/musicVideo/{id}")
    public Result deleteMusicVideo(@PathVariable("id") Integer id) {
        log.info("删除MV id :{}",id);
        return Result.success(localMusicService.deleteMusicVideo(id));
    }

    @ApiOperation("添加歌曲")
    @PostMapping("/addSong")
    public Result addSong(@RequestBody LocalMusicDO localMusicDO) {
        log.info("添加歌曲 歌曲 :{}",localMusicDO);
        boolean flag = localMusicService.addSong(localMusicDO);
        if (flag) {
            return Result.success(true);
        } else {
            return Result.fail("此歌曲已在你的本地歌单中");
        }
    }

    @ApiOperation("获得所有的分类")
    @GetMapping("/sorts")
    public Result getSorts() {
        log.info("获得所有的分类");
        return Result.success(localMusicService.getAllSort());
    }

    @ApiOperation("更新歌曲播放次数")
    @PutMapping("/updateSongPlayCount")
    public Result updateSongPlayCount(@RequestParam("id") Integer id) {
        log.info("更新歌曲播放次数 id :{}", id);
        return Result.success(localMusicService.updateSongPlayCount(id));
    }
}
