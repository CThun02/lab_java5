package com.example.lab1.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeControlller {
    HttpServletRequest req;
    HttpServletResponse res;

    public @Autowired HomeControlller(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    @GetMapping("/login")
    private String loginView(){
        return "/webapp/WEB-INF/views/login";
    }
    @PostMapping("/login")
    private String login(){
        Cookie cookie = new Cookie("user", req.getParameter("acc"));
        res.addCookie(cookie);
        System.out.println("Tài Khoản: " + req.getParameter("acc"));
        System.out.println("Mật Khẩu: " + req.getParameter("pass"));
        System.out.println("Cookies: " + req.getCookies()[0].getValue());
        req.setAttribute("mess", "Set value by HttpRequest");
        return "/webapp/WEB-INF/views/home";
    }
}
