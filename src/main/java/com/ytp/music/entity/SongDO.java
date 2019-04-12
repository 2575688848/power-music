package com.ytp.music.entity;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class SongDO {

    private String id;

    private String name;

    private String singer;

    private String url;

    private String pic;

    private String lrc;

    private Integer time;
}
