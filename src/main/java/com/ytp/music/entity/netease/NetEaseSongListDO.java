package com.ytp.music.entity.netease;

import com.ytp.music.entity.SongDO;
import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class NetEaseSongListDO {

    private Integer songListCount;

    private Integer songListPlayCount;

    private Long songListUserId;

    private List<SongDO> songs;
}
