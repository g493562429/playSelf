package com.gn.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author: gn
 * @Date: 2020-9-9
 * @Description:
 */
@RestController
@RequestMapping("/gg")
public class DemoController {

        public static void main(String[] args) {
            Enumeration<String> days;
            Vector<String> dayNames = new Vector<>();
            dayNames.add("Sunday");
            dayNames.add("Monday");
            dayNames.add("Tuesday");
            dayNames.add("Wednesday");
            dayNames.add("Thursday");
            dayNames.add("Friday");
            dayNames.add("Saturday");
            days = dayNames.elements();
            while (days.hasMoreElements()){
                System.out.println(days.nextElement());
            }
        }

    @GetMapping("/ss")
    public WiBean printParam(){
        WiBean bean = new WiBean();
        bean.setNames("key");
        bean.setValues("value");
        return bean;
    }

}
