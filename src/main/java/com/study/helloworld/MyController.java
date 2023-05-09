package com.study.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        return "Security-LoginForm (3)";
    }

    @RequestMapping("/guest/welcome")
    public String welcome1() {
        return "guest/welcome1";
    }

    @RequestMapping("/member/welcome")
    public String welcome2() {
        return "member/welcome2";
    }

    @RequestMapping("/admin/welcome")
    public String welcome3() {
        return "admin/welcome3";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "security/loginForm";
    }

    // 로그인 에러 발생 시, 로그인 페이지에서 에러 내용 노출할 예정으로 기존 에러페이지 리퀘스트 맵핑은 주석 처리
    /*
    @RequestMapping("/loginError")
    public String loginError() {
        return "security/loginError";
    }
    */
}
