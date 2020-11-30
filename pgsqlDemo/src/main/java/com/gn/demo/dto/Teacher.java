package com.gn.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: gn
 * @Date: 2020-10-26
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    @ApiModelProperty("插入操作时不用传")
    private int id;
    private String name;
    private int number;
}
