package com.gn.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.gn.demo.Factory.ReturnJsonFactory;
import com.gn.demo.dto.DateDTO;
import com.gn.demo.model.ReturnJson;
import com.gn.demo.service.CalendarService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author: gn
 * @Date: 2021-3-16
 * @Description:
 */
@Slf4j
@Service
public class CalendarServiceImpl implements CalendarService {

    @Override
    public ReturnJson queryDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
        if (StringUtils.isEmpty(date)) {
            date = simpleDateFormat.format(new Date());
        }
        DateDTO dateDTO = this.callQueryDate(date);
        log.info("dateDTO:{}", JSON.toJSONString(dateDTO));
        return ReturnJsonFactory.success(dateDTO);
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
