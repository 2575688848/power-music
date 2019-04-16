package com.ytp.music.entity;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class NetEaseSongListDO {

    private Long id;

    private String title;

    private String creator;

    private String description;

    private String coverImgUrl;

    private Integer songNum;

    private Long playCount;

}
