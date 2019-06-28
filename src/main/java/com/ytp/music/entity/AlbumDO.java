package com.ytp.music.entity;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class AlbumDO {

    private String albumMID;

    private String albumName;

    private String albumPic;

    private String publicTime;

    private String singerName;

    private Integer song_count;
}
