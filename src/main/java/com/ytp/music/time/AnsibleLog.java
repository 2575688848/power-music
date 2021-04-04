package com.lehe.higo.oxp.model;

import lombok.Data;

import java.util.List;

/**
 * @author ytp
 * @date 2020/9/22
 */

@Data
public class AnsibleLog {

    private String ip;

    private Boolean status;

    private List<String> logList;

    private List<String> otherErrorLogList;
}
