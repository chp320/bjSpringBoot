package com.study.helloworld;

import com.study.helloworld.dao.ISimpleBbsDao;
import com.study.helloworld.service.ISimpleBbsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/* MyController에서 DAO를 직접 호출하던 것을 service를 이용하는 것으로 수정 */

@Controller
public class MyController {

    /* 생성자 주입 start */
//    private final ISimpleBbsDao dao;   // 인터페이스 타입의 객체 변수 -> mapper를 사용했기에 현 코드상에서는 implements한 클래스가 없음
    private final ISimpleBbsService bbsService;

    //    public MyController(ISimpleBbsDao dao) {
//        this.dao = dao;
//    }
    public MyController(ISimpleBbsService bbsService) {
        this.bbsService = bbsService;
    }
    /* 생성자 주입 end */

    @RequestMapping("/")
    public String root() throws Exception {
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
//        model.addAttribute("list", dao.listDao());
        model.addAttribute("list", bbsService.list());

//        int nTotalCount = dao.articleCount();
        int nTotalCount = bbsService.count();
        System.out.println("Count: " + nTotalCount);

        return "list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");    // queryString으로 전달되는 id값을 넘겨서 조회한다.
//        model.addAttribute("dto", dao.viewDao(sId));
        model.addAttribute("dto", bbsService.view(sId));

        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {

        return "writeForm";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        /* -- 파라미터가 Map으로 변경됨에 따라 주석 처리
        dao.writeDao(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content"));
         */
        String sName = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");

        Map<String, String> map = new HashMap<String, String>();
        map.put("item1", sName);
        map.put("item2", sTitle);
        map.put("item3", sContent);

//        int nResult = dao.writeDao(map);    // insert 성공 시 1, 실패 시 0 리턴 */
        int nResult = bbsService.write(map);
        System.out.println("Write: " + nResult);

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
//        int nResult = dao.deleteDao(sId);   // delete 성공 시 delete 수행 개수만큼 리턴, 실패 시 0 리턴 (update 도 동일) */
        int nResult = bbsService.delete(sId);
        System.out.println("Delete: " + nResult);

        return "redirect:list";
    }
}
