package com.moonmagician.reloads.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class LinuxNoteController {

    @RequestMapping("/linuxnote")
    public String toLinuxNotePath() {
        return "redirect:/linuxnote/1";
    }
}
