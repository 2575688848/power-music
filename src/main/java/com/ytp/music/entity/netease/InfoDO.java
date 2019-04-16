package com.ytp.music.entity.netease;

import lombok.Data;

/**
 * @author ytp
 */

@Data
public class InfoDO {

    /**
     * 是否被喜欢
     */
    private Boolean liked;

    /**
     * 喜欢的人数量
     */
    private Long likedCount;

    /**
     * 分享数量
     */
    private Long shareCount;
}
