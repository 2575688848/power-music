package com.ytp.music.controller;

import com.ytp.music.base.Result;
import com.ytp.music.entity.local.UserDO;
import com.ytp.music.entity.netease.NetEaseSongListDO;
import com.ytp.music.service.IUserService;
import com.ytp.music.service.impl.MusicServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ytp
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/user")
@Api(tags = "user", value = "/api/v1/user", description = "用户接口")
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public Result registerUser(@RequestBody UserDO userDO) {
        log.info("注册用户 用户 :{}",userDO);
        return Result.success(userService.register(userDO));
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody UserDO userDO) {
        log.info("用户登录 用户 :{}",userDO);
        return Result.success(userService.login(userDO));
    }


    @ApiOperation("编辑用户")
    @PutMapping("/update")
    public Result update(@RequestBody UserDO userDO) {
        log.info("编辑用户 用户 :{}",userDO);
        return Result.success(userService.update(userDO));
    }

    @ApiOperation("添加网易云用户")
    @PostMapping("/add/{id}")
    public Result addNetEaseUser(@RequestBody com.ytp.music.entity.UserDO userDO, @PathVariable("id") Integer id) {
        log.info("添加网易云用户 用户 :{}",userDO);
        return Result.success(userService.addNetEaseUser(userDO, id));
    }

    @ApiOperation("获得网易云用户")
    @GetMapping("/netUser/{id}")
    public Result getNetEaseUser(@PathVariable("id") Long id) {
        log.info("获得网易云用户 用户id :{}",id);
        return Result.success(userService.getNetUser(id));
    }

    @ApiOperation("获得分析结果")
    @GetMapping("/analysis/{id}")
    public Result getAnalysis(@PathVariable("id") Integer id) {
        log.info("获得分析结果 用户id :{}",id);
//        return Result.success(userService.getAnalysis(id));
        return Result.success("哈哈哈 分析结果");
    }
}
