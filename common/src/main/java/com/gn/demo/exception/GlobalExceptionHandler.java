package com.gn.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: gn
 * @Date: 2020-10-28 16:44
 * @Description: 全局异常捕获类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final static String ERROR_PAGE = "error";

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e) {
        log.info("报错了，全局捕获到异常:{}", e.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName(ERROR_PAGE);
        return mv;
    }

    @ModelAttribute
    //应用到所有@RequestMapping注解方法
    //此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对
    public void addUser(Model model) {
        model.addAttribute("msg", "此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对");
    }

    @InitBinder
    //应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
    public void initBinder(WebDataBinder binder) {
    }

} 