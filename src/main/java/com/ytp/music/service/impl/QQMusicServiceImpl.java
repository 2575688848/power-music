package com.ytp.music.service.impl;

import com.ytp.music.base.ResponseDO;
import com.ytp.music.base.Result;
import com.ytp.music.base.UrlConstant;
import com.ytp.music.entity.SongListDO;
import com.ytp.music.service.IQQMusicService;
import com.ytp.music.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ytp
 */
@Service("qqMusicService")
@Slf4j
public class QQMusicServiceImpl implements IQQMusicService {


    @Override
    public Result<SongListDO> getSongList(String id) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("id", id);
        String content = CommonUtils.getResponseString(params, UrlConstant.QQ_SONGLIST_URL);
        ResponseDO<SongListDO> responseDO = JSON.parseObject(content, new TypeReference<ResponseDO<SongListDO>>() {
        });
        if (responseDO == null) {
            log.error("获取音乐列表信息失败");
            return Result.fail("获取音乐列表信息失败");
        }
        if (responseDO.getCode() != 200) {
            return Result.fail(responseDO.getResult());
        }
        return Result.success(responseDO.getData());
    }
}
