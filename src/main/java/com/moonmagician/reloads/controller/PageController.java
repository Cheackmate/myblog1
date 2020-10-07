package com.moonmagician.reloads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/allproject")
    public String toLinuxNotePath() {
        return "redirect:/allproject/1";
    }

}
