package com.ytp.music.entity.local;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 */
@Data
public class AnalysisDO {

    private String date;

    private String analysis1;

    private String analysis2;

    private String analysis3;

    private List<LocalMusicDO> songs;
}
