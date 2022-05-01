package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @GetMapping("/")
    public String home(){
        return "hello";
    }

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "userLogin";
    }
}
