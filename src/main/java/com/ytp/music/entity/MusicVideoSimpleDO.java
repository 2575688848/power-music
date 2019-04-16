package com.ytp.music.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ytp
 */
@Data
public class MusicVideoSimpleDO {

    private String id;

    private String name;

    private String desc;

    private String pic;

    @ApiModelProperty("时长")
    private Integer time;

    private String singer;

    private String url;

    @ApiModelProperty("发行时间")
    private String publictime;

    private String playCount;
}
