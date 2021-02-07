package com.gn.demo.config;

import com.alibaba.fastjson.JSONObject;
import com.gn.demo.dto.UserDto;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: gn
 * @Date: 2020-7-25
 * @Description:
 */
@ConfigurationProperties(prefix = "demo.gn")
@Component
@ToString
public class CommonConfig {
    private String ceShi;
    private List<String> list;
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(String value) {
        this.userDto = JSONObject.parseObject(value, UserDto.class);
    }

    /*@Value("#{T(com.gn.demo.utils.MapDecoder).decodeMap('${demo.gn.map:}')}")
        private Map<String, String> map;*/
    private Map<String, Integer> map;

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(String value) {
        this.map = (Map<String, Integer>) JSONObject.parse(value);
    }

    public String getCeShi() {
        return ceShi;
    }

    public void setCeShi(String ceShi) {
        this.ceShi = ceShi;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public CommonConfig() {
    }

    public CommonConfig(String ceShi, List<String> list, Map<String, Integer> map) {
        this.ceShi = ceShi;
        this.list = list;
        this.map = map;
    }
}
