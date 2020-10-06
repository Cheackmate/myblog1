package com.moonmagician.reloads.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moonmagician.reloads.entity.Linuxnote;

public interface LinuxNoteMapper extends BaseMapper<Linuxnote> {
    Integer datacount();
}
