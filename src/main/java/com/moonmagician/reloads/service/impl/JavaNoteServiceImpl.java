package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.JavaNoteMapper;
import com.moonmagician.reloads.service.JavaNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaNoteServiceImpl implements JavaNoteService {

    @Autowired
    JavaNoteMapper javaNoteMapper;

    @Override
    public Integer datacount() {
        return javaNoteMapper.datacount();
    }
}
