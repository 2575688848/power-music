package com.ytp.music.dao;

import com.ytp.music.entity.local.RegionDO;
import com.ytp.music.entity.local.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ytp
 */
@Repository
@Mapper
public interface RegionDao {

    /**
     * 获取地址
     * @param id
     * @return
     */
    RegionDO getRegion(@Param("id") Integer id);
}
