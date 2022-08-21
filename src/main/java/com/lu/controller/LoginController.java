package com.lu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){

        if(!username.isEmpty()&&"123456".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名密码错误");
            return "index";
        }
    }

}
