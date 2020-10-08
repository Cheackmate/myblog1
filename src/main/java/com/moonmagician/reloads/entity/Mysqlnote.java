package com.moonmagician.reloads.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;


@Data
public class Mysqlnote {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 在图片前显示的标题
     */
    private String title;

    /**
     * 对应的图片的位置
     */
    private String imgurl;

    /**
     * 创建的时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createtime;

    /**
     * 对该项目的描述，在鼠标滑动到图片上之后显示
     */
    private String describetext;

    /**
     * 评论数量
     */
    private Integer discusscount;


    /**
     * 查看数量
     */
    private Integer visitcount;

    /**
     * 类型，判断是自己写的笔记还是自己做的项目展示
     */
    private Integer type;

    /**
     * 访问页面的路径
     */
    private String webpagepath;


    public String getWebpagepath() {
        return webpagepath;
    }

    public void setWebpagepath(String webpagepath) {
        this.webpagepath = webpagepath;
    }

    public String getDescribetext() {
        return describetext;
    }

    public void setDescribetext(String describetext) {
        this.describetext = describetext;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getDiscusscount() {
        return discusscount;
    }

    public void setDiscusscount(Integer discusscount) {
        this.discusscount = discusscount;
    }

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    @Override
    public String toString() {
        return "Imgview{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", createtime=" + createtime +
                ", describetext='" + describetext + '\'' +
                ", discusscount=" + discusscount +
                ", visitcount=" + visitcount +
                ", type=" + type +
                ", webpagepath='" + webpagepath + '\'' +
                '}';
    }
}
