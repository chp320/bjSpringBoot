package com.study.helloworld;

import com.study.helloworld.dao.ISimpleBbsDao;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyController {

    /* 생성자 주입 start */
    private final ISimpleBbsDao dao;   // 인터페이스 타입의 객체 변수 -> mapper를 사용했기에 현 코드상에서는 implements한 클래스가 없음

    public MyController(ISimpleBbsDao dao) {
        this.dao = dao;
    }
    /* 생성자 주입 end */

    @RequestMapping("/")
    public String root() throws Exception {
        // MyBatis: SimpleBBS
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());

        return "list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");    // queryString으로 전달되는 id값을 넘겨서 조회한다.
        model.addAttribute("dto", dao.viewDao(sId));

        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {

        return "writeForm";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
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
