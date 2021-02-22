package com.gn.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: gn
 * @Date: 2021-1-18
 * @Description: 统一返参格式
 */
@Data
@Getter
@Setter
public class ReturnJson {
    private String resultCode;
    private String resultMsg;
    private Object data;

    public ReturnJson(String resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public ReturnJson(Object data){
        this.resultCode = "0";
        this.resultMsg = "请求处理成功";
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return "0".equalsIgnoreCase(this.resultCode);
    }

    @JsonIgnore
    public String getDataJsonString(){
        return (new Gson()).toJson(this.getData());
    }

    public boolean error(){
        return StringUtils.equals(this.resultCode, "-1");
    }

    @JsonIgnore
    public boolean isDataEmpty(){
        Object data = this.getData();
        if (data == null){
            return true;
        }else {
            return data instanceof String && StringUtils.isBlank(data.toString());
        }
    }
}
