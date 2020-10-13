package com.gn.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WiBean {


    /**
     * 忽略参数返回
     */
    @JsonIgnore
    private String names;

    /**
     * 用于属性上、set/get方法上，该属性序列化后可重命名。
     */
    private String values;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
    
}
