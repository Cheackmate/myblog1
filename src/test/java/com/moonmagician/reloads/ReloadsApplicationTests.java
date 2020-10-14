package com.moonmagician.reloads;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moonmagician.reloads.entity.Imgview;
import com.moonmagician.reloads.mapper.ImgviewMapper;
import com.sun.javafx.iio.ImageMetadata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReloadsApplicationTests {

    @Autowired
    private ImgviewMapper imgviewMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void viewTest(){
        QueryWrapper<Imgview> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("age",23);
        IPage<Imgview> page = new Page<>(1,10);
        IPage<Imgview> userIPage = imgviewMapper.selectPage(page, queryWrapper);
        long total = userIPage.getTotal();
        System.out.println(total);
        userIPage.getRecords().forEach(user-> System.out.println(user.getClass()));
    }
}
