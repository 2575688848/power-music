package com.ytp.music.base;

import lombok.Data;

/**
 * @author ytp
 */
@Data
public class ResponseDO<T> {

    private String result;

    private Integer code;

    private T data;
}
