package com.moonmagician.reloads.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moonmagician.reloads.entity.Gitnote;

public interface GitNoteMapper extends BaseMapper<Gitnote> {
    Integer datacount();
}
