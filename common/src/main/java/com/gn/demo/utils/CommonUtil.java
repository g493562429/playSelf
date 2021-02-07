package com.gn.demo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: gn
 * @Date: 2021-1-19
 * @Description: 通用工具类
 */
public class CommonUtil {

    /**
     * 获取用户名
     * @return String
     */
    public static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return "";
        }
        String userName = authentication.getName();
        return userName.toUpperCase();
    }

    /**
     * 获取request
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获取入参
     * @return Map<String, String[]>
     */
    public static Map<String, String[]> getParameterMap(){
        HttpServletRequest request = getRequest();
        return request.getParameterMap();
    }
}
