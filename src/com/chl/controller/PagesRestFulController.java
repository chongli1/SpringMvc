package com.chl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagesRest")
public class PagesRestFulController {
    @RequestMapping("/{path}")   //path ：路径
    public String path(@PathVariable("path") String path){  //@PathVariable:转变为动态的路径变量
        System.out.println("path = " + path);
        return path;
    }
}
