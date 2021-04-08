package com.gn.demo.service;

import com.gn.demo.model.ReturnJson;

/**
 * @Author: gn
 * @Date: 2021-3-16
 * @Description:
 */
public interface CalendarService {
    /**
     *  查询万年历
     * @param date date
     * @return ReturnJson
     */
    ReturnJson queryDate(String date);
}
