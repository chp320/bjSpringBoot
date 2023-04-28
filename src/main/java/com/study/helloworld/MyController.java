package com.study.helloworld;

import com.study.helloworld.jdbc.MyUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /* 생성자 주입 start */
    private final MyUserDAO myUserDAO;

    public MyController(MyUserDAO myUserDAO) {
        this.myUserDAO = myUserDAO;
    }
    /* 생성자 주입 end */


    @RequestMapping("/")
    // 메서드에 @ResponseBody 어노테이션이 있는 경우, 리턴되는 스트링값 자체만 웹브라우저로 전달
    public @ResponseBody String root() throws Exception {
        return "JdbcTemplate 사용하기";
    }

    //    @GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userlistPage(Model model) {
        model.addAttribute("users", myUserDAO.list());

        return "userlist";
    }
}
