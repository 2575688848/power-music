package com.ytp.music.dao;

import com.ytp.music.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface NetEaseDao {

    /**
     * 添加网易云用户
     * @param userDO
     * @return
     */
    Boolean addUser(UserDO userDO);

    /**
     * 获得用户信息
     * @param id
     * @return
     */
    UserDO getUser(Long id);
}
