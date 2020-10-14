package com.moonmagician.reloads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JavaNoteController {
    @RequestMapping("/javanote/note/{id}")
    public String toAllProjectPath(@PathVariable("id") int id) {
        //该路径下所有文件夹的名称并且依次放入一个数组中，然后按照id来找到对应的数据
        //简单方法全用数字命名
        System.out.println(id);
        return "bar/pagelist/javanote/"+id;
    }
}
