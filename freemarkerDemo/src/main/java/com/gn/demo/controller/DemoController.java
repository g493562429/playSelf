package com.gn.demo.controller;


import com.gn.demo.dto.Student;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gn
 * @Date: 2020-5-22 22:28
 * @Description:
 */
@Controller
@RequestMapping("/gn")
public class DemoController {
    @GetMapping("demo")
    @ApiModelProperty(name = "测试1", value = "测试1")
    public String demo(Model model) {
        Student gn2 = Student.builder().age("23").name("gn2").build();
        model.addAttribute("name", "gn");
        model.addAttribute("age", "18");
        model.addAttribute("student", gn2);
        return "test1";
    }
    @PutMapping("demo")
    @ApiModelProperty(name = "测试2", value = "测试2")
    public String demo2(Model model) {
        Student gn2 = Student.builder().age("23").name("gn2").build();
        model.addAttribute("name", "gn");
        model.addAttribute("age", "18");
        model.addAttribute("student", gn2);
        return "test1";
    }

    @GetMapping("feign")
    @ApiModelProperty(name = "测试3", value = "测试3")
    public String demo3(){
        return "hello world";
    }

    public static void main(String[] args) throws IOException {
        File file = new File("data.xlsx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);

        String a = "hello 2";
        allocate.put(a.getBytes());
        //此处必须要调用buffer的flip方法
        allocate.flip();
        channel.write(allocate);
        channel.close();
        fileOutputStream.close();
    }
}
