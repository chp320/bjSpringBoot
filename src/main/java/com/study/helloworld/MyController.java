package com.study.helloworld;

import com.study.helloworld.service.IBuyTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    IBuyTicketService buyTicketService;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        return "Transaction X (2)";
    }

    @RequestMapping("/buy_ticket")
    public String buy_ticket() {
        return "buy_ticket";
    }

    @RequestMapping("/buy_ticket_card")
    public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
                                  @RequestParam("amount") String amount,
                                  @RequestParam("error") String error,
                                  Model model) {
        int nResult = buyTicketService.buy(consumerId, Integer.parseInt(amount), error);

        model.addAttribute("consumerId", consumerId);
        model.addAttribute("amount", amount);

        if (nResult == 1) {
            return "buy_ticket_end";
        } else {
            return "buy_ticket_error";
        }
    }
}
