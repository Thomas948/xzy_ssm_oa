package com.xzy.service.impl;

import com.xzy.entity.WorkType;
import com.xzy.mapper.WorkTypeMapper;
import com.xzy.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:51
 * @description:
 */
@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    @Autowired
    private WorkTypeMapper workTypeMapper;

    @Transactional(readOnly = true,rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public List<WorkType> getWorkTypes() {
        return workTypeMapper.getWorkTypes();
    }
}
