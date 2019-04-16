package com.ytp.music.entity;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class SongListSimpleDO {

    private String id;

    private String name;

    private String creator;

    private String createTime;

    private String pic;

    private String playCount;

}
