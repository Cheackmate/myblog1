package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.OtherNoteMapper;
import com.moonmagician.reloads.service.OtherNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherNoteServiceImpl implements OtherNoteService {
    @Autowired
    OtherNoteMapper otherNoteMapper;

    @Override
    public Integer datacount() {
        return otherNoteMapper.datacount();
    }
}
