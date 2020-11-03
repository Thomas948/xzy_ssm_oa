package com.xzy.service.impl;

import com.xzy.entity.SubjectType;
import com.xzy.mapper.SubjectTypeMapper;
import com.xzy.service.SubjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:59
 * @description:
 */
@Service
public class SubjectTypeServiceImpl implements SubjectTypeService {

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;

    @Transactional(readOnly = true,rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public List<SubjectType> getSubjectTypes() {
        return subjectTypeMapper.getSubjectTypes();
    }
}
