package com.ytp.music.entity.netease;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class UserDO {

    private Integer userType;

    private Integer vipType;

    private String nickname;

    private Long userId;

    private String avatarUrl;

}
