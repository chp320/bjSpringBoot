package com.study.helloworld;

import com.study.helloworld.dao.ISimpleBbsDao;
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
    private final ISimpleBbsDao dao;

    public MyController(ISimpleBbsDao dao) {
        this.dao = dao;
    }
    /* 생성자 주입 end */

    @RequestMapping("/")
    public String root() throws Exception {
        // JdbcTemplate: SimpleBBS
        return "redirect:list";     // list.jsp 로 리다이렉트
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());
        return "list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @RequestMapping("/write")
    public String write(Model model, HttpServletRequest request) {
        dao.writeDao(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content"));
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        dao.deleteDao(request.getParameter("id"));
        return "redirect:list";
    }
}
