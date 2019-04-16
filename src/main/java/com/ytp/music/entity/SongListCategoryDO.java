package com.ytp.music.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class SongListCategoryDO {

    private String categoryGroupName;

    private List<Item> items;

}
