package com.moonmagician.reloads.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moonmagician.reloads.entity.Imgview;

import java.util.List;

public interface ImgviewMapper extends BaseMapper<Imgview> {

//    List<Imgview> selectPageExt(Page<Imgview> p,int page ,int size);

    Integer datacount();
}
