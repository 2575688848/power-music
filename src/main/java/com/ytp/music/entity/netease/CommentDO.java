package com.ytp.music.entity.netease;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class CommentDO {

    private UserDO user;

    private List<CommentDO> beReplied;

    private Long likedCount;

    private Long time;

    private String content;

}
