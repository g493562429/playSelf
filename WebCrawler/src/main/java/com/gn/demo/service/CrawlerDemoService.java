package com.gn.demo.service;

import com.gn.demo.dto.WebCrawlerDto;

/**
 * @Author: gn
 * @Date: 2020-8-1
 * @Description:
 */
public interface CrawlerDemoService {
    /**
     * 爬取网页内容功能
     * @param urlStr url字符串
     * @return WebCrawlerDto
     */
    WebCrawlerDto getContext(String urlStr);
}
