package com.ytp.music.entity.local;

import lombok.Data;

import java.util.Date;

/**
 * @author ytp
 */
@Data
public class SongFolderDO {

    private Integer id;

    private String folderName;

    private Integer songCount;

    private Integer playCount;

    private Integer userId;

    /**
     * 生成时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

}
