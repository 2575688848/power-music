package com.ytp.music.entity.netease;

import lombok.Data;

/**
 * @author ytp
 */

@Data
public class VideoDO {

    private String coverUrl;

    private Long playTime;

    private Long size;

    private String videoId;

    private String title;

    private String description;

}
