package com.gn.demo.controller;

import com.alibaba.fastjson.JSON;
import com.gn.demo.dto.DateDTO;
import com.gn.demo.service.impl.CalendarServiceImpl;
import com.google.common.collect.Maps;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
public class CalendarControllerTest extends TestCase {
    @Autowired
    private CalendarServiceImpl calendarService;

    public void testQueryDate() {
        String date = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
        if (StringUtils.isEmpty(date)) {
            date = simpleDateFormat.format(new Date());
        }
        DateDTO dateDTO = this.callQueryDate(date);
        log.info("dateDTO:{}", JSON.toJSONString(dateDTO));
        System.out.println(dateDTO);
    }

    private DateDTO callQueryDate(String date) {
        String url = "http://v.juhe.cn/calendar/day?date=" + date + "&key=b7e884eec32a8f2f26f60288f41512f8";
        /*DateRequest dateRequest = new DateRequest();
        dateRequest.setDate(date);*/
        Map<String, String> dateRequest = Maps.newHashMap();
        dateRequest.put("key", "b7e884eec32a8f2f26f60288f41512f8");
        dateRequest.put("date", date);
        log.info("dateRequest:{}", JSON.toJSONString(dateRequest));
        RestTemplate restTemplate = new RestTemplate();
        DateDTO dateDTO = restTemplate.postForObject(url, dateRequest, DateDTO.class);
        return dateDTO;
    }
}