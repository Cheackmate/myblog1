package com.moonmagician.reloads.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Consumer implements Serializable {

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     * 之后可以使用md5进行加密操作
     */
    private String password;
    /**
     * 用户头文件位置
     */
    @TableField(value = "head_portrait")
    private String headPortrait;
    /**
     * 用户消息
     */
    private String message;

    /**
     * 用户邮件数量
     */

    private String emailcount;
    /**
     * 提示数量
     */
    private String tipcount;

    /**
     * 注册时间
     * @return
     */
    private Date registertime;

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getEmailcount() {
        return emailcount;
    }

    public void setEmailcount(String emailcount) {
        this.emailcount = emailcount;
    }

    public String getTipcount() {
        return tipcount;
    }

    public void setTipcount(String tipcount) {
        this.tipcount = tipcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
