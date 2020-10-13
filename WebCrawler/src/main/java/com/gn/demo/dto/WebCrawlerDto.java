package com.gn.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: gn
 * @Date: 2020-8-1
 * @Description: 爬虫测试类反参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebCrawlerDto {

    /**
     * id
     */
    private String id;
    /**
     * 内容
     */
    private String context;
}
