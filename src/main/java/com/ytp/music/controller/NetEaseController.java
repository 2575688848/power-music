package com.ytp.music.controller;

import com.ytp.music.base.Result;
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
@RequestMapping("/api/v1/NetEaseMusic")
@Api(tags = "netEase-music", value = "/api/v1/netEaseMusic", description = "网易云音乐接口")
public class NetEaseController {

    @Resource
    private MusicServiceImpl musicServiceImpl;

    @ApiOperation("获取用户信息")
    @GetMapping("/user")
    public Result getUser(@RequestParam("s") String s, @RequestParam("type") String type,
                            @RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
        log.info("获取歌单列表 关键词 :{}, 类型 :{}", s, type);
        return musicServiceImpl.getUser(s, type, limit, offset);
    }

    @ApiOperation("获取用户歌单列表")
    @GetMapping("/songList/{uid}")
    public Result getNetEaseSongList(@PathVariable("uid") Long uid) {
        log.info("获取用户歌单列表 uid :{}", uid);
        return musicServiceImpl.getNetEaseSongList(uid);
    }


}
