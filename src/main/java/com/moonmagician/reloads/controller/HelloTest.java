package com.moonmagician.reloads.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moonmagician.reloads.entity.Imgview;
import com.moonmagician.reloads.mapper.ImgviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class HelloTest {

    @Autowired
    ImgviewMapper imgviewService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello wrold! and flower";
    }

    @RequestMapping("/logins")
    public String logins(){
        return "success";
    }

}
