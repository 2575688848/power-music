package com.ytp.music.entity.netease;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class UserDynamicDO {

    private Long lasttime;

    private Integer code;

    private List<EventDO> events;
}
