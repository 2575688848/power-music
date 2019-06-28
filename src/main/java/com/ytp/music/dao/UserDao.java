package com.ytp.music.dao;

import com.ytp.music.entity.local.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface UserDao {

    /**
     * 获取用户
     * @param username
     * @param password
     * @return
     */
    UserDO getUser(@Param("username") String username, @Param("password") String password);

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    UserDO getUserById(Integer id);

    /**
     * 注册用户
     * @param userDO
     * @return
     */
    Boolean register(UserDO userDO);

    /**
     * 用户登录
     * @param userDO
     * @return
     */
    Boolean login(UserDO userDO);

    /**
     * 用户信息修改
     * @param userDO
     * @return
     */
    Boolean update(UserDO userDO);
}
