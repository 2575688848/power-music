package com.ytp.music.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class ResultUser {

    private List<UserDO> userprofiles;

    private Integer userprofileCount;
}
