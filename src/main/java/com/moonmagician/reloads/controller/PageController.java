package com.moonmagician.reloads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/mysqlnote/note/{id}")
    public String toMySQLNotePath1(@PathVariable("id") int id) {
        //该路径下所有文件夹的名称并且依次放入一个数组中，然后按照id来找到对应的数据
        //简单方法全用数字命名
        System.out.println(id);
        return "bar/pagelist/mysqlnote/"+id;
    }

    @RequestMapping("/gitnote")
    public String toGitNotePath() {
        return "redirect:/gitnote/1";
    }

    @RequestMapping("/gitnote/note/{id}")
    public String toGitNotePath1(@PathVariable("id") int id) {
        //该路径下所有文件夹的名称并且依次放入一个数组中，然后按照id来找到对应的数据
        //简单方法全用数字命名
        System.out.println(id);
        return "bar/pagelist/gitnote/"+id;
    }

    @RequestMapping("/othernote")
    public String toOtherNotePath() {
        return "redirect:/othernote/1";
    }

    @RequestMapping("/othernote/note/{id}")
    public String toOtherNotePath1(@PathVariable("id") int id) {
        //该路径下所有文件夹的名称并且依次放入一个数组中，然后按照id来找到对应的数据
        //简单方法全用数字命名
        System.out.println(id);
        return "bar/pagelist/othernote/"+id;
    }
}
