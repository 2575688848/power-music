package com.ytp.music.leet;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseServiceDTO extends ServiceCollectionDTO{

    @NotBlank(message = "版本号")
    @ApiModelProperty(value="版本号", required = true, example = "1.8")
    private String version;

    private Integer status;

    private Date ctime;

    private Date mtime;
}
