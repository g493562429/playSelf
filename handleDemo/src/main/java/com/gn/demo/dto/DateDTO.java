package com.gn.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: gn
 * @Date: 2021-3-16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateDTO {

    private String reason;
    private Result result;
    @JsonAlias("error_code")
    private Long errorCode;
}
