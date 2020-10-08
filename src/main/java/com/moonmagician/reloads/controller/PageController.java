package com.moonmagician.reloads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/allproject")
    public String toAllProjectPath() {
        return "redirect:/allproject/1";
    }

    @RequestMapping("/javanote")
    public String toJavaNotePath() {
        return "redirect:/javanote/1";
    }

    @RequestMapping("/mysqlnote")
    public String toMySQLNotePath() {
        return "redirect:/mysqlnote/1";
    }

    @RequestMapping("/gitnote")
    public String toGitNotePath() {
        return "redirect:/gitnote/1";
    }

    @RequestMapping("/othernote")
    public String toOtherNotePath() {
        return "redirect:/othernote/1";
    }
}
