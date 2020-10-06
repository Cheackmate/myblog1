package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.LinuxNoteMapper;
import com.moonmagician.reloads.service.LinuxNoteService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinuxNoteServiceImpl implements LinuxNoteService {


    @Autowired
    LinuxNoteMapper linuxNoteMapper;
    @Override
    public Integer datacount() {
        return linuxNoteMapper.datacount();
    }
}
