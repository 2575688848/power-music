package com.ytp.music.entity.netease;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class EventDO {

    /**
     * 动态时间
     */
    private Long eventTime;

    private String json;

    private Long id;

    private Integer type;

    private InfoDO info;

}
