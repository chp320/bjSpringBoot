package com.study.helloworld;

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

    @RequestMapping("/")
    // 메서드에 @ResponseBody 어노테이션이 있는 경우, 리턴되는 스트링값 자체만 웹브라우저로 전달
    public @ResponseBody String root() throws Exception {
        return "Validator (3)";
    }

    // 단순히 jsp 페이지 리턴
    @RequestMapping("/insertForm")
    public String insert1() {
        return "createPage";
    }

    @RequestMapping("/create")
//    public String insert2(@ModelAttribute("dto") ContentDto contentDto, BindingResult result) {
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
        String page = "createDonePage";
        System.out.println(contentDto);

//        ContentValidator validator = new ContentValidator();
//        validator.validate(contentDto, result);
        if (result.hasErrors()) {
//            System.out.println("getAllErrors : " + result.getAllErrors());

            if (result.getFieldError("writer") != null) {
                System.out.println("1:" + result.getFieldError("writer").getCode());
            }
            if (result.getFieldError("content") != null) {
                System.out.println("2:" + result.getFieldError("content").getCode());
            }
            page = "createPage";
        }

        return page;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ContentValidator());
    }
}
