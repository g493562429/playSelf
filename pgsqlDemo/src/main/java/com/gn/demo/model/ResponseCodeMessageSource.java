package com.gn.demo.model;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @Author: gn
 * @Date: 2021-1-18
 * @Description:
 */
public class ResponseCodeMessageSource extends ResourceBundleMessageSource {
    public ResponseCodeMessageSource(){
        this.setBasenames(new String[]{"response-code", "config/response-code"});
        this.setDefaultEncoding("UTF-8");
    }

    public static MessageSourceAccessor getAccessor(){
        return new MessageSourceAccessor(new ResponseCodeMessageSource());
    }
}
