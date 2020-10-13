package com.gn.demo.controller;

import com.gn.demo.dto.WebCrawlerDto;
import com.gn.demo.service.CrawlerDemoService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: gn
 * @Date: 2020-8-1
 * @Description:
 */
@RequestMapping("/gnCrawler")
@RestController
public class WebCrawlerController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{});
    }

    @Resource
    private CrawlerDemoService crawlerDemoService;

    @GetMapping("/demo")
    public WebCrawlerDto demo(String urlStr){
        return crawlerDemoService.getContext(urlStr);
    }

}
