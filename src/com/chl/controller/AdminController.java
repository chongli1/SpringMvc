package com.chl.controller;

import com.chl.bean.AdminInfo;
import com.chl.bean.Dog;
import com.chl.bean.Lover;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")  //api：返回json数据
public class AdminController {
    //注册成功后，如果是单体项目-----就要跳转的登录页面，这个跳转是后台的 转发 或 重定向，
    // 总之是后台负责 跳转，携带数据的跳转页面的
    //如果是新型项目，即前后端分离的，那么 后台 只负责返回给前端json数据，
    //跳转 是前端来处理的，前端根据 后台返回的 code 代码 进行跳转
    //如果前端负责跳转，他会起一个好听的名字，叫做 路由！

    //什么是前后端分离 即：指的是项目上的分离 和 数据上的分离
    //项目上的分离：前端一个项目，后台一个项目 2个项目
    //数据上的分离：还是一个项目，只不过是 前后端 用json 来交互数据
    //很少在用 jstl/ el表达式 来写项目， 他们的认证 是 session

    //layui 在 SSM/Springboot 框架的使用，其实是 数据上的分离，也可以是项目上的分离
    //那么他就是json交互的，那么 后台只需要 给他返回json数据就可以了

    //以前在 servlet 中，是通过 resp.getWriter().print(new JSONObject.toString(map) )  输出json的
    //现在，使用 mvc框架 的
    //adminName: 利   以前接收参数 req.getParamter("adminName")
    //adminPwd: 123
    //adminPwdR: 123

    //第一种收取参数方式：数据类型接收参数！！！
    //layui 版本
    @RequestMapping("/reg")
    @ResponseBody  //这个注解就是 返回给前端的 json 数据！！   响应请求，不跳转，只发送json数据，用于ajax请求
    public Map reg(String adminName, String adminPwd, String adminPwdR, String adminTime, String adminSex, String adminCountry, String adminHobby,String adminClose){
        System.out.println("adminName = " + adminName);
        System.out.println("adminTime = " + adminTime);
        System.out.println("adminSex = " + adminSex);
        System.out.println("adminCountry = " + adminCountry);
        System.out.println("adminHobby = " + adminHobby);
        System.out.println("adminClose = " + adminClose);
        Map codemap = new HashMap();
        if (!adminPwd.equals(adminPwdR)) {
            codemap.put("code", "4401");
            codemap.put("msg", "你输入的密码和重复密码不一致，注册失败");
            return codemap;
        }
        if (adminName.length()<= 0) {
            codemap.put("code", "4402");
            codemap.put("msg", "adminName表单写完整");
            return codemap;
        }
        if (adminPwd.length()<= 0) {
            codemap.put("code", "4402");
            codemap.put("msg", "adminPwd表单写完整");
            return codemap;
        }
        codemap.put("code", 0);
        codemap.put("msg", "注册成功");
        return codemap;
    }

    //传统版本 不返回json 跳转使用转发或者重定向
    @RequestMapping("/regForm")
    public String regForm(String adminName, String adminPwd){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        //注册成功跳转到登录页
        return "loginForm";
    }

    //SpringMVC 第二种接收参数方式，用的是叫做 实体类接收参数
    @RequestMapping("/regByBean")
    @ResponseBody
    public Map regBean(AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "注册成功");
        return codeMap;
    }

    //ajax 接收 数组/集合
    @RequestMapping("/ajax03")
    @ResponseBody
    public Map ajax03(@RequestParam("ids[]") List<Integer> ids){  //前端 ids[]  后台ids
                                                                  //当前后端参数不一样时，那么我们使用注解调整
        for(Integer id : ids){
            System.out.println("id = " + id);
        }
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "请求访问成功");
        codeMap.put("data", ids);
        return codeMap;
    }

    //ajax 接收 JSON 对象
    @RequestMapping("/ajax04")
    @ResponseBody
    public Map ajax04(@RequestBody  AdminInfo adminInfo){   //@RequestBody 注解就是指的是 前端用json请求
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "请求访问成功");
        codeMap.put("data", adminInfo);
        return codeMap;
    }

    //ajax05 接收前端传来的多个对象
    @RequestMapping("/ajax05")
    @ResponseBody
    public Map ajax05(@ModelAttribute Lover lover, @ModelAttribute Dog dog){  //ModelAttribute 模型绑定
        System.out.println("lover = " + lover);
        System.out.println("dog = " + dog);
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "请求访问成功");
        codeMap.put("data1", lover);
        codeMap.put("data2", dog);
        return codeMap;
    }

    //如果前端传来多个对象，需要根据请求的前缀 进行绑定
    @InitBinder("lover")
    public void binding01(WebDataBinder webDataBinder){  //webDataBinder 网络数据绑定
        webDataBinder.setFieldDefaultPrefix("lover.");   //设置前缀
    }

    @InitBinder("dog")
    public void binding2(WebDataBinder webDataBinder){  //webDataBinder 网络数据绑定
        webDataBinder.setFieldDefaultPrefix("dog.");    //设置前缀
    }

    //json06 json 收取多个对象
    //@GetMapping("/ajax06")
    @RequestMapping("/ajax06")
    @ResponseBody     //@GetMapping 不能和 @ResponseBody 同时使用，无法拿到参数
    public Map ajax06(@RequestBody List<Lover> loverList){  //@RequestBody 他是方法体中拿取的数据，所以不能使用Get请求！！
        for (Lover lover : loverList) {
            System.out.println("lover = " + lover);
        }
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "请求访问成功");
        codeMap.put("data", loverList);
        return codeMap;
    }

    //ajax07 收取map集合传参
    @RequestMapping("/ajax07")
    @ResponseBody    //十分常用，servlet 多表的动态参数获取，就是用的map  可以搞定一切！！！
    public Map ajax07(@RequestBody Map map){
        System.out.println("map的adminName = " + map.get("adminName"));
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("msg", "请求访问成功");
        codeMap.put("data", map);
        return codeMap;
    }

    // ajax08 收取对象+常用类型 混合
    @RequestMapping("/ajax08")
    @ResponseBody
    public Map ajax08(Lover lover, @RequestParam(value = "limit", required = false, defaultValue = "5") Integer pageSize, Integer page){  //@RequestParam 默认  defaultValue = "5" 5页  required = false 为false时参数可带可不带
        System.out.println("lover = " + lover);
        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        return null;
    }

    //以上是前后端分离，最新项目用到的知识点，那么也有传统项目， 后台负责到另一个界面

    //第一种 SpringMVC的 传值方式； 原始方式： request + session + request的转发
    //传统的mvc的方法（不返回json数据，不使用@ResponseBody），他要跳转jsp，跳转jsp方式1，返回值是String
    //页面传值：即 四大作用域 request session application  page
    @RequestMapping("/yuansheng")   //什么是传值 登录页（admin， 123456）------ yuansheng() ----(admin)  home
    //public String yuansheng(AdminInfo adminInfo, HttpSession session){
    public String yuansheng(HttpSession session, HttpServletRequest request){
        System.out.println("原生方式 页面传值");
        //System.out.println("adminInfo = " + adminInfo);
        //登录如果验证成功，那么，需要把 登录信息放到作用于域中
        //session.setAttribute("adminInfo", adminInfo);
        String adminName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");
        request.setAttribute("adminName",adminName);
        request.setAttribute("adminPwd",adminPwd);

        //servlet 的转发 request.getRequestDispatcher("home.jsp").forward(request,respone);
        //return "home";   //这个和 PagesController 里的查找jsp的 方法 没联系
        //return "forward:/WEB-INF/pages/home.jsp";   //springMVC 的转发
        //return "forward:/pages/home";
        //重定向：servlet中 response。sendredDirect（"/www.baidu.com"）  重定向携带不了数据
        return "redirect:https://www.baidu.com";   //不带/  和带 / 的区别
        //return "redirect:/https://www.baidu.com";   //不带/  和带 / 的区别
        //不带/ 的路径：https://www.baidu.com/
        //带/ 的路径：http://localhost:8080/https://www.baidu.com   绝对路径
    }

    //第二种 SpringMVC的 传值方式
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(AdminInfo adminInfo){
        //modelAndView 模型和视图，数据和显示   modelAndView 可以代替转发功能
        ModelAndView mv = new ModelAndView();
        mv.addObject("adminName", adminInfo.getAdminName());
        mv.addObject("adminPwd", adminInfo.getAdminPwd());
        System.out.println("以上model的绑定，即数据的绑定");
        mv.setViewName("home");
        return mv;
    }

    //第三种 SpringMVC的 传值方式  model  简约
    @RequestMapping("/model")
    public String model(AdminInfo adminInfo, Model model){
        model.addAttribute("adminName", adminInfo.getAdminName());
        model.addAttribute("adminPwd", adminInfo.getAdminPwd());
        return "home";
    }

    //第四种 SpringMVC的 传值方式   modelMap    简约
    @RequestMapping("/modelMap")
    public String modelMap(AdminInfo adminInfo, ModelMap modelMap){
        modelMap.put("adminName", adminInfo.getAdminName());
        modelMap.put("adminPwd", adminInfo.getAdminPwd());
        return "home";
    }

    //第五种 SpringMVC的 传值方式   Map  简约
    @RequestMapping("/map")
    public String map(AdminInfo adminInfo, Map<String, Object> map){
        map.put("adminName", adminInfo.getAdminName());
        map.put("adminPwd", adminInfo.getAdminPwd());
        return "home";
    }

}
