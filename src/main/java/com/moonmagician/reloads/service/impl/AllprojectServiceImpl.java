package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.AllprojectMapper;
import com.moonmagician.reloads.service.AllprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllprojectServiceImpl implements AllprojectService {
    @Autowired
    AllprojectMapper allprojectMapper;
    @Override
    public Integer datacount() {
        return allprojectMapper.datacount();
    }
}
