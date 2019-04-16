package com.ytp.music.entity.netease;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class CommentResultDO {

    private Integer code;

    private List<CommentDO> topComments;

    private List<CommentDO> hotComments;

    private List<CommentDO> comments;

    private Long total;

}
