package com.moonmagician.reloads.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moonmagician.reloads.entity.Javanote;

public interface JavaNoteMapper extends BaseMapper<Javanote> {
    Integer datacount();
}
