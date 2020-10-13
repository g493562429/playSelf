package com.gn.demo.controller;

import com.gn.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void demo() {
        System.out.println(demoService.demoC());
    }

    @Test
    public void toJson() {
        System.out.println("demoService.demoFeign()");
    }
}