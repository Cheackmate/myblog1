package com.moonmagician.reloads.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moonmagician.reloads.entity.Consumer;
import com.moonmagician.reloads.entity.Imgview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImgviewService {

    /**
     * 查找所有bg图片信息
     * @return
     */
    List<Imgview> search();



//    IPage<Imgview> selectPageExt(Imgview user, int page, int pageSize);


    Integer datacount();
}
