package com.example.demo.controller;

import  com.example.demo.service.MemberService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 스프링 컨테이너가 멤버 서비스를 가져와줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
