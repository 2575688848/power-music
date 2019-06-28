package com.ytp.music.service;

import com.ytp.music.entity.local.AnalysisDO;
import com.ytp.music.entity.local.UserDO;

/**
 * @author ytp
 */
public interface IUserService {

    /**
     * 注册用户
     * @param userDO
     * @return
     */
    UserDO register(UserDO userDO);

    /**
     * 用户登录
     * @param userDO
     * @return
     */
    UserDO login(UserDO userDO);

    /**
     * 用户信息修改
     * @param userDO
     * @return
     */
    Boolean update(UserDO userDO);

    /**
     * 添加云用户
     * @param userDO
     * @param id
     * @return
     */
    Boolean addNetEaseUser(com.ytp.music.entity.UserDO userDO, Integer id);

    /**
     * 获得云用户
     * @param id
     * @return
     */
    com.ytp.music.entity.UserDO getNetUser(Long id);

    /**
     * 获取分析结果
     * @param id
     * @return
     */
    AnalysisDO getAnalysis(Integer id);
}
