package com.gn.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: gn
 * @Date: 2021-1-20
 * @Description:
 */
@Data
public class UserDto {
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("图片验证码")
    private String checkCode;

    @ApiModelProperty("输入的验证码")
    private String inputCode;
}
