package com.example.demo.controllers;


import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";//前后拼 templates html
    }
    @PostMapping("/user/login")
    public String login(@RequestParam("logname") String user,
                        @RequestParam("logpass") String password,
                        Model model, HttpServletRequest request){
        if(password.contentEquals("123456")){
            model.addAttribute("user",user);
            model.addAttribute("password",password);


            HttpSession session = request.getSession(true);//session创建
            session.setAttribute("username",user);
            session.setAttribute("password",password);
            System.out.println(session.getId());//会话id
            System.out.println(session.getAttribute("username"));

         return "hello";
        }
        else{
            model.addAttribute("msg","用户名密码错误！");
            return "index" ;
        }
    }
    @GetMapping("/user/login")
    public String login(HttpServletRequest httpServletRequest,Model model){
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession==null)
            return "index";
        model.addAttribute("user",httpSession.getAttribute("username"));
        model.addAttribute("password",httpSession.getAttribute("password"));
        return "hello";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("url","img/demo-1-bg.jpg");
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regist(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestParam("password")String password,
                         @RequestParam("repassword")String repassword,
                         @RequestParam("telephone")String telephone,
                         @RequestParam("gender")String gender)
    {
        System.out.println(email);
        return "index";
    }
}
