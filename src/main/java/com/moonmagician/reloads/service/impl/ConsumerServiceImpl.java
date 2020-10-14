package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.entity.Consumer;
import com.moonmagician.reloads.mapper.ConsumerMapper;
import com.moonmagician.reloads.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    //自动注入类
    @Autowired
    ConsumerMapper consumerMapper;
    @Override
    public List<Consumer> search() {
        //所有所有用户，baseMapper他里面的方法。
        List<Consumer> consumers = consumerMapper.selectList(null);
        return consumers;
    }

    @Override
    public void insertuser(Consumer consumer) {
        consumerMapper.insert(consumer);
    }
}
