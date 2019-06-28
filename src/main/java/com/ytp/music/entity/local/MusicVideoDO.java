package com.ytp.music.entity.local;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ytp
 */
@Data
public class MusicVideoDO {

    private Integer id;

    private Integer userId;

    private String videoType;

    private String name;

    private String pic;

    private String singer;

    private String url;

    @ApiModelProperty("发行时间")
    private String publictime;

    private String playCount;
}
