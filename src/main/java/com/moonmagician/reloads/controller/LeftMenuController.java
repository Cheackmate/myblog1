package com.moonmagician.reloads.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moonmagician.reloads.entity.Allproject;
import com.moonmagician.reloads.entity.Imgview;
import com.moonmagician.reloads.entity.Linuxnote;
import com.moonmagician.reloads.mapper.AllprojectMapper;
import com.moonmagician.reloads.mapper.ImgviewMapper;
import com.moonmagician.reloads.mapper.LinuxNoteMapper;
import com.moonmagician.reloads.service.AllprojectService;
import com.moonmagician.reloads.service.ImgviewService;
import com.moonmagician.reloads.service.LinuxNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LeftMenuController {

    @Autowired
    private ImgviewMapper imgviewMapper;

    @Autowired
    private ImgviewService imgviewService;
    /***
     * 访问请求返回到主页
     * @return
     */
    @RequestMapping({"/index","/"})
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();

        //首先查找总的数据数量
        Integer datacount = imgviewService.datacount();
        //算出总共有几页
        int pageNumber = datacount/10+1;


        List<Imgview> list = new ArrayList<>();
        //分页查找当前页的数据
        QueryWrapper<Imgview> queryWrapper = new QueryWrapper<>();
        //        pagenumberqueryWrapper.eq("age",23);
        IPage<Imgview> page = new Page<>(1,10);
        IPage<Imgview> userIPage = imgviewMapper.selectPage(page, queryWrapper);
        int total = (int) userIPage.getTotal();

        session.setAttribute("pageindex",1);
        session.setAttribute("pagelist",userIPage);
        session.setAttribute("pagesize",total);
        session.setAttribute("pagenumber",pageNumber);

        userIPage.getRecords().forEach(user-> list.add(user));


        session.setAttribute("datas",list);

        userIPage.getRecords().forEach(user-> System.out.println(user));
        return "index";
    }

    @RequestMapping("/index/{id}")
    public String index(@PathVariable("id") int id, HttpServletRequest request){
        HttpSession session = request.getSession();

        //首先查找总的数据数量
        Integer datacount = imgviewService.datacount();
        int pageNumber = datacount/10+1;

        //分页查找当前页的数据
        QueryWrapper<Imgview> queryWrapper = new QueryWrapper<>();
        //        queryWrapper.eq("age",23);
        IPage<Imgview> page = new Page<>(id,10);
        IPage<Imgview> userIPage = imgviewMapper.selectPage(page, queryWrapper);
        long total = userIPage.getTotal();

        session.setAttribute("pageindex",id);
        session.setAttribute("pagelist",userIPage);
        session.setAttribute("pagesize",total);
        session.setAttribute("pagenumber",pageNumber);


        List<Imgview> list = new ArrayList<>();
        userIPage.getRecords().forEach(user-> list.add(user));
        session.setAttribute("datas",list);

//        System.out.println(total);
//        userIPage.getRecords().forEach(user-> System.out.println(user));
        return "index";
    }


    /**
     * 返回讨论区页面
     * 此页面类似于聊天室
     * @return
     */
    @RequestMapping("/talk")
    public String talk(){
        return "bar/navigation/talk";
    }

    /**
     * 返回絮絮叨叨页面
     * 此页面返回的是我自己记录的一些琐碎的生活日常
     * @return
     */
    @RequestMapping("/myspeak")
    public String mySpeak(){
        return "bar/navigation/myspeak";
    }

    /**
     * 返回历史记录页面
     * 此页面记录着我所发布的所有东西的日期和内容链接
     * @return
     */
    @RequestMapping("/history")
    public String history(){
        return "bar/navigation/history";
    }


    /**
     * 返回问题反馈页面
     * 注册用户可以在这里面留言发现的问题。我可以来选择已读和已解决等选项
     * @return
     */
    @RequestMapping("/question")
    public String question(){
        return"bar/navigation/question";
    }

    /**
     * 返回留言区域页面
     * 此页用户可以进行留言主要偏向于自己想说的话。
     * @return
     */
    @RequestMapping("/message")
    public String message(){
        return "bar/navigation/message";
    }

    /**
     * 返回自我介绍页面
     * 此页面展示我的相关网络信息
     * @return
     */
    @RequestMapping("/introduction")
    public String introduction(){
        return"bar/constitute/introduction";
    }


    @Autowired
    AllprojectMapper allprojectMapper;

    @Autowired
    AllprojectService allprojectService;
    /**
     * 返回个人项目页面
     * 此页面展示我做个的一些项目案例，并且指出相关项目在github上面的位置
     * @return
     */
    @RequestMapping("/allproject/{id}")
    public String allproject(@PathVariable("id") int id,Model model){
        //首先查找总的数据数量
        Integer datacount = allprojectService.datacount();
        int pageNumber = datacount/10+1;

        //分页查找当前页的数据
        QueryWrapper<Allproject> queryWrapper = new QueryWrapper<>();
        //        queryWrapper.eq("age",23);
        IPage<Allproject> page = new Page<>(id,10);
        IPage<Allproject> userIPage = allprojectMapper.selectPage(page, queryWrapper);
        long total = userIPage.getTotal();

        model.addAttribute("allprojectpageindex",id);
        model.addAttribute("allprojectpagelist",userIPage);
        model.addAttribute("allprojectpagesize",total);
        model.addAttribute("allprojectpagenumber",pageNumber);


        List<Allproject> list = new ArrayList<>();
        userIPage.getRecords().forEach(user-> list.add(user));
        model.addAttribute("allprojectdatas",list);
        return "bar/constitute/allproject";
    }

    /**
     * 之后为计算机相关的笔记页面
     */

    @Autowired
    LinuxNoteMapper linuxNoteMapper;
    @Autowired
    LinuxNoteService linuxNoteService;
    /**
     * 返回笔记整理下linux笔记页面
     * 此页面是linux的相关笔记
     * @return
     */
    @RequestMapping("/linuxnote/{id}")
    public String linuxnote(@PathVariable("id") int id,Model model){
        //首先查找总的数据数量
        Integer datacount = linuxNoteService.datacount();
        int pageNumber = datacount/10+1;

        //分页查找当前页的数据
        QueryWrapper<Linuxnote> queryWrapper = new QueryWrapper<>();
        //        queryWrapper.eq("age",23);
        IPage<Linuxnote> page = new Page<>(id,10);
        IPage<Linuxnote> userIPage = linuxNoteMapper.selectPage(page, queryWrapper);
        long total = userIPage.getTotal();

        model.addAttribute("linuxnotepageindex",id);
        model.addAttribute("linuxnotepagelist",userIPage);
        model.addAttribute("linuxnotepagesize",total);
        model.addAttribute("linuxnotepagenumber",pageNumber);


        List<Linuxnote> list = new ArrayList<>();
        userIPage.getRecords().forEach(user-> list.add(user));
        model.addAttribute("linuxnotedatas",list);
        return "bar/constitute/linuxnote";
    }
    /**
     * 返回笔记整理下java笔记页面
     * 此页面是java的相关笔记
     * @return
     */
    @RequestMapping("/javanote")
    public String javanote(){
        return "bar/constitute/javanote";
    }
    /**
     * 返回笔记整理下vue笔记页面
     * 此页面是vue的相关笔记
     * @return
     */
    @RequestMapping("/vuenote")
    public String vuenote(){
        return "bar/constitute/vuenote";
    }
    /**
     * 返回笔记整理下redisnote笔记页面
     * 此页面是redisnote的相关笔记
     * @return
     */
    @RequestMapping("/redisnote")
    public String redisnote(){
        return "bar/constitute/redisnote";
    }
    /**
     * 返回笔记整理下mysqlnote笔记页面
     * 此页面是mysqlnote的相关笔记
     * @return
     */
    @RequestMapping("/mysqlnote")
    public String distributednote(){
        return "bar/constitute/mysqlnote";
    }

    /**
     * 返回git笔记列表页面
     * @return
     */
    @RequestMapping("/gitnote")
    public String gitnote(){
        return "bar/constitute/gitnote";
    }

    /**
     * 返回其他笔记列表页面
     * @return
     */
    @RequestMapping("/othernote")
    public String othernote(){
        return "bar/constitute/othernote";
    }
}
