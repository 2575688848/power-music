package com.ytp.music.controller;

import com.ytp.music.base.Result;
import com.ytp.music.entity.SongListDO;
import com.ytp.music.service.impl.MusicServiceImpl;
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
@RequestMapping("/api/v1/qqMusic")
@Api(tags = "qq-music", value = "/api/v1/qqMusic", description = "qq音乐接口")
public class QQMusicController {

    @Resource
    private MusicServiceImpl musicServiceImpl;

    @ApiOperation("获取歌单列表")
    @GetMapping("/songList/{id}")
    public Result<SongListDO> getSongList(@PathVariable("id") String id) {
        log.info("获取歌单列表 id :{}", id);
        return musicServiceImpl.getSongList(id);
    }

    @ApiOperation("搜索音乐/MV/album")
    @GetMapping("/search")
    public Result getResult(@RequestParam("s") String s, @RequestParam("type") String type,
                                               @RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
        log.info("获取歌单列表 关键词 :{}, 类型 :{}", s, type);
        return musicServiceImpl.getResult(s, type, limit, offset);
    }

    @ApiOperation("获取音乐详情")
    @GetMapping("/music/detail/{id}")
    public Result getResult(@PathVariable("id") String id) {
        log.info("获取音乐详情 id :{}", id);
        return musicServiceImpl.getDetailMusic(id);
    }

    @ApiOperation("获取MV")
    @GetMapping("/musicVideo/{id}")
    public Result getMusicVideo(@PathVariable("id") String id) {
        log.info("获取音乐MV详情 id :{}", id);
        return musicServiceImpl.getMusicVideo(id);
    }

    @ApiOperation("获取歌单分类")
    @GetMapping("/songListCategory")
    public Result getSongListCategory() {
        log.info("获取热门歌单分类");
        return musicServiceImpl.getSongListCategory();
    }

    @ApiOperation("获取分类的歌单列表")
    @GetMapping("/songsOfCategory/{categoryId}")
    public Result getSongsOfCategory(@PathVariable("categoryId") Integer categoryId) {
        log.info("获取分类的歌单列表 categoryId  :{}", categoryId);
        return musicServiceImpl.getSongsOfCategory(categoryId);
    }

    @ApiOperation("获取热门mv列表")
    @GetMapping("/hotMusicVideo")
    public Result getHotMusicVideoList(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
        log.info("获取热门mv列表");
        return musicServiceImpl.getHotMusicVideoList(limit, offset);
    }

    @ApiOperation("获取专辑歌单列表")
    @GetMapping("/albumSongList/{id}")
    public Result<SongListDO> getAlbumSongList(@PathVariable("id") String id) {
        log.info("获取歌单列表 id :{}", id);
        return musicServiceImpl.getAlbumSongList(id);
    }

}
