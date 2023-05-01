package com.study.helloworld;

import com.study.helloworld.dao.ISimpleBbsDao;
import com.study.helloworld.jdbc.IMyUserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyController {

    /* 생성자 주입 start */
    private final IMyUserDao userDao;   // 인터페이스 타입의 객체 변수 -> mapper를 사용했기에 현 코드상에서는 implements한 클래스가 없음

    public MyController(IMyUserDao userDao) {
        this.userDao = userDao;
    }
    /* 생성자 주입 end */

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        return "MyBatis 사용하기";
    }

    //    @GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model) {
        model.addAttribute("users", userDao.list());

        return "userlist";
    }
}
