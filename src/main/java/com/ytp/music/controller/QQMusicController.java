package com.ytp.music.controller;

import com.ytp.music.base.Result;
import com.ytp.music.entity.SongListDO;
import com.ytp.music.service.impl.QQMusicServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private QQMusicServiceImpl qqMusicServiceImpl;

    @GetMapping("/songList/{id}")
    public Result<SongListDO> getSongList(@PathVariable("id") String id) {
        log.info("获取歌单列表 id :{}", id);
        return qqMusicServiceImpl.getSongList(id);
    }
}
