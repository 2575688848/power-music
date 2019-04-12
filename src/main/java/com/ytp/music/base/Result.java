package com.ytp.music.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author ytp
 */
@ApiModel
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4569216979022946969L;
    @ApiModelProperty(
            notes = "返回数据",
            required = true
    )
    private T data;
    @ApiModelProperty(
            notes = "成功标识",
            example = "true",
            required = true
    )
    private boolean isSuccess = false;
    @ApiModelProperty(
            notes = "结果信息",
            example = "执行成功！",
            required = true
    )
    private String resultMsg = "执行失败!";

    public Result() {
    }

    public static <T> Result<T> fail() {
        return new Result();
    }

    public static <T> Result<T> fail(String msg) {
        Result result = fail();
        result.setResultMsg(msg);
        return result;
    }

    public static <T> Result<T> success() {
        Result result = new Result();
        result.setResultMsg("执行成功！");
        result.setIsSuccess(true);
        return result;
    }

    public static <T> Result<T> success(T t) {
        Result result = success();
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(Result<T> result) {
        if(result == null) {
            return success();
        } else {
            result.setResultMsg("执行成功！");
            result.setIsSuccess(true);
            return result;
        }
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
