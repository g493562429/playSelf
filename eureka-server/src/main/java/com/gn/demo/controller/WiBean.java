package com.gn.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.assertj.core.util.Sets;
import org.springframework.util.CollectionUtils;

import java.util.*;

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

    public static void main(String[] args) {
        String bodyColor1 = "红,黄,绿,青";
        String bodyColor2 = "绿,青,蓝,紫";
        String bodyColor3 = "红,黄,蓝,紫";

        List<String> bodyColors1 = CollectionUtils.arrayToList(bodyColor1.split(","));
        List<String> bodyColors2 = CollectionUtils.arrayToList(bodyColor2.split(","));
        List<String> bodyColors3 = CollectionUtils.arrayToList(bodyColor3.split(","));
        HashSet<String> objects = Sets.newHashSet();
        System.out.println("------111: " + JSON.toJSONString(objects));
        objects.addAll(bodyColors1);
        objects.addAll(bodyColors2);
        objects.addAll(bodyColors3);
        System.out.println("------222: " + JSON.toJSONString(objects));

        String join = String.join(",", objects);
        System.out.println(join);
    }
}
