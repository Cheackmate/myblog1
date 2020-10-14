package com.moonmagician.reloads.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moonmagician.reloads.entity.Gitnote;
import com.moonmagician.reloads.entity.Othernote;

public interface OtherNoteMapper extends BaseMapper<Othernote> {
    Integer datacount();
}
