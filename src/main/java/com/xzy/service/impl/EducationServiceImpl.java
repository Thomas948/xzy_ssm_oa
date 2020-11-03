package com.xzy.service.impl;

import com.xzy.entity.Education;
import com.xzy.mapper.EducationMapper;
import com.xzy.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:06
 * @description:
 */
@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationMapper educationMapper;

    @Transactional(readOnly = true,rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public List<Education> getEducationList() {
        return educationMapper.getEducationList();
    }
}
