package com.chl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("请求进入hello");
        return "rello";  //故意写成rello，必须和xxx.jsp的名字一样
    }
}
