package com.gn.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * @Author: gn
 * @Date: 2021-2-7
 * @Description:
 */
public class MapDecoder {

    public static Map<String, String> decodeMap(String value) {
        try {
            return JSONObject.parseObject(value, new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
