package com.lu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SignoutController {
    @RequestMapping("/signout")
    public String signout(HttpSession httpSession){
        httpSession.removeAttribute("username");
        return "redirect:/";
    }
}
