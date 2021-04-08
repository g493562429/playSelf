package com.gn.demo.dto;

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
public class DateRequest {
    private final String key = "b7e884eec32a8f2f26f60288f41512f8";
    private String date;
}
