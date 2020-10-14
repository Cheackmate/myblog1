package com.moonmagician.reloads.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moonmagician.reloads.entity.Imgview;
import com.moonmagician.reloads.mapper.ImgviewMapper;
import com.moonmagician.reloads.service.ImgviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgviewServiceImpl implements ImgviewService {

    @Autowired
    private ImgviewMapper imgview;

    @Override
    public List<Imgview> search() {
        List<Imgview> imgviews = imgview.selectList(null);
        return imgviews;
    }

    @Override
    public Integer datacount() {
        return imgview.datacount();
    }

}
