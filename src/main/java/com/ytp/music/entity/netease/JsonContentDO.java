package com.ytp.music.entity.netease;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class JsonContentDO {

    private String msg;

    private SongDO song;

    private VideoDO video;
}
