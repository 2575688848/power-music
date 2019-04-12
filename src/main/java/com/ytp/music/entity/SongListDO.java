package com.ytp.music.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class SongListDO {

    private String id;

    private String title;

    private String desc;

    private String author;

    private String songnum;

    private String logo;

    private List<SongDO> songs;
}
