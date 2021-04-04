package com.ytp.music.leet;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceDTO extends ServiceCollectionDTO{

    private Integer gitProjectId;

    private String sshUrlToRepo;

    private String httpUrlToRepo;

    private String webUrl;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    private Integer namespaceId;

    private String script;

    private Date ctime;

    private Date mtime;
}
