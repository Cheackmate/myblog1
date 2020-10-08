package com.moonmagician.reloads.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moonmagician.reloads.entity.Mysqlnote;

public interface MysqlNoteMapper extends BaseMapper<Mysqlnote> {
    Integer datacount();
}
