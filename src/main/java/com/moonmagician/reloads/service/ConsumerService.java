package com.moonmagician.reloads.service;

import com.moonmagician.reloads.entity.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsumerService {

    /**
     * 查找所有用户
     * @return
     */
    List<Consumer> search();
}
