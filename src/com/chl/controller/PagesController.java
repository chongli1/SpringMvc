package com.chl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该 控制类 是为了 查找jsp 或者 带参数访问jsp 或者跳转的
 */

@Controller
@RequestMapping("/pages")
public class PagesController {
    @RequestMapping("/reg")
    public String reg(){
        System.out.println("请求进入reg注册界面");
        return "reg";  //故意写成 rello， 强调 必须和 xxx.jsp 中的 xxx一样
    }

    @RequestMapping("/regForm")
    public String regform(){
        return "regForm";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginForm")
    public String loginform(){
        return "loginForm";
    }

    @RequestMapping("/ajaxCommit")
    public String ajaxCommit(){
        return "ajaxCommit";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
