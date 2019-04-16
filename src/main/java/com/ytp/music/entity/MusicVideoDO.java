package com.ytp.music.entity;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class MusicVideoDO{

    private String docid;

    private Long mv_id;

    private String mv_name;

    private String mv_pic_url;

    private Long play_count;

    private String singer_name;

    private Long singerid;

    private String v_id;
}
