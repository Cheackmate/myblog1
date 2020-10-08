package com.moonmagician.reloads.controller;

import com.moonmagician.reloads.entity.Consumer;
import com.moonmagician.reloads.service.impl.ConsumerServiceImpl;
import com.moonmagician.reloads.service.impl.ImgviewServiceImpl;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Controller
public class LoginController {

    /**
     * 自动注入consumerservice类
     */
    @Autowired
    ConsumerServiceImpl consumerService;

    /**
     * 自动注入ImgviewServiceImpl类
     * @return
     */
    @Autowired
    ImgviewServiceImpl imgviewService;

    @RequestMapping("/userlog")
    public String userlog(){
        return "/logins/login";
    }

    @PostMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password, HttpSession session){

        //遍历出数据库中所有的用户数据。
        List<Consumer> search = consumerService.search();
        for (Consumer list:search) {
            if(list.getUsername().equals(username) && list.getPassword().equals(password)){
                session.setAttribute("message",list.getMessage());
                session.setAttribute("email",list.getEmailcount());
                session.setAttribute("tip",list.getTipcount());
                session.setAttribute("headurl",list.getHeadPortrait());
                session.setAttribute("logincode", "success");
                session.setAttribute("username",list.getUsername());
                session.setAttribute("registertime",list.getRegistertime());
                return "redirect:/";
            }
        }
        return "redirect:/userlog";
    }

    /**
     * 接收到注册请求，跳转到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "/logins/register";
    }


    /**
     * 接收注册的post数据，然后把它添加到数据库中。
     * @return
     */
    @PostMapping("/userRegister")
    public String userRegister(String username,String password){
        //把用户数据放到数据库中，如果用户名重复返回重复，用户名不重复添加成功。
        Consumer consumer = new Consumer();
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setHeadPortrait("/userlist/otheruser/title.png");
        consumer.setEmailcount("0");
        consumer.setMessage("0");
        consumer.setTipcount("0");
        Date date = new Date();
        date.getTime();
        consumer.setRegistertime(date);

        consumerService.insertuser(consumer);
        return "redirect:/userlog";
    }

    /**
     * 用户登出，把用户的session清空
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
//        request.getSession().invalidate();//直接让session失效
        Enumeration em = request.getSession().getAttributeNames();  //得到session中所有的属性名
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString()); //遍历删除session中的值
        }
        return "redirect:/";
    }

}
