package com.gn.demo.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gn
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Son extends Father {
    private Life life;

    public static void main(String[] args) {
        Father cuiShan = new Father();
        cuiShan.setFace("handsome");
        cuiShan.setHeight("180");
        Life cuiShanLife = new Life();
        cuiShanLife.setStatus("alive");
        cuiShan.setLife(cuiShanLife);
//        Son wuJi = new Son();
//        BeanUtils.copyProperties(cuiShan, wuji);
        Father wuJi = JSONObject.parseObject(JSONObject.toJSONBytes(cuiShan), Father.class);
        Life wuJiLife = wuJi.getLife();
        wuJiLife.setStatus("alive");
        wuJi.setLife(wuJiLife);
        // 翠山后来自刎了
        cuiShanLife.setStatus("dead");
        System.out.println(JSON.toJSONString(cuiShan));
        System.out.println(JSON.toJSONString(wuJi));
    }
}