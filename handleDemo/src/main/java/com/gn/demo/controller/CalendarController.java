package com.gn.demo.controller;

import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: gn
 * @Date: 2021-3-16
 * @Description:
 */
@RestController
@RequestMapping("calendar")
@Slf4j
public class CalendarController {

    @Resource
    private CalendarService calendarService;

    @GetMapping("queryDate")
    public ReturnJson queryDate(String date){
        return calendarService.queryDate(date);
    }
}
