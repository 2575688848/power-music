package com.ytp.music.entity.local;

import lombok.Data;

import java.util.Date;

/**
 * @author ytp
 */
@Data
public class LocalMusicDO {

    private Integer id;

    private Integer userId;

    private String songId;

    private Integer folderId;

    private String songType;

    private Integer playCount;

    private String name;

    private String singer;

    private String url;

    private String pic;

    private String lrc;

    private Long time;

    /**
     * 生成时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;
}
