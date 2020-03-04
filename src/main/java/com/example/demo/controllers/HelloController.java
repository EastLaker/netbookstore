package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                        Map<String,Object> map){
        if(password.contentEquals("123456"))
         return "hello";
        else{
            map.put("msg","用户名密码错误");
            return "index" ;
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("url","img/demo-1-bg.jpg");
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String regist(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestParam("password")String password,
                         @RequestParam("repassword")String repassword,
                         @RequestParam("telephone")String telephone,
                         @RequestParam("gender")String gender)
    {
        System.out.println(gender);
 return "登陆成功！";
    }
}
