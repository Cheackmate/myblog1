package com.moonmagician.reloads.service.impl;

import com.moonmagician.reloads.mapper.MysqlNoteMapper;
import com.moonmagician.reloads.service.MysqlNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlNoteServiceImpl implements MysqlNoteService {

    @Autowired
    MysqlNoteMapper mysqlNoteMapper;
    @Override
    public Integer datacount() {
        return mysqlNoteMapper.datacount();
    }
}
