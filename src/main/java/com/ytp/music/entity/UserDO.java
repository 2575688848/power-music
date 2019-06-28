package com.ytp.music.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ytp
 */

@Data
public class UserDO {

    private Integer id;

    private Integer province;

    private Integer city;

    @ApiModelProperty("封面url")
    private String avatarUrl;

    private Long birthday;

    private Long userId;

    private Integer userType;

    private String nickname;

    private String signature;

    private String description;

    private String detailDescription;

    private String backgroundUrl;

    private Integer vipType;

    private String remarkName;

    private Integer followeds;

    private Integer follows;

    private Integer playlistCount;

    private Integer playlistBeSubscribedCount;

    private String address;

    private String date;
}

