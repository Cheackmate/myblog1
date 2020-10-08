package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.GitNoteMapper;
import com.moonmagician.reloads.service.GitNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitNoteServiceImpl implements GitNoteService {
    @Autowired
    GitNoteMapper gitNoteMapper;
    @Override
    public Integer datacount() {
        return gitNoteMapper.datacount();
    }
}
