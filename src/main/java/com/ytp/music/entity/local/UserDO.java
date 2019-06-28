package com.ytp.music.entity.local;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class UserDO {

    private Integer id;

    private String username;

    private String nickname;

    private String sex;

    private String tel;

    private String email;

    private String birthday;

    private String address;

    private String password;

    private String url;

    private Long easeId;
}
