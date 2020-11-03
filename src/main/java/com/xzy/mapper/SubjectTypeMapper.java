package com.xzy.mapper;

import com.xzy.entity.SubjectType;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:56
 * @description:
 */
public interface SubjectTypeMapper {

    List<SubjectType> getSubjectTypes();

    SubjectType getSubjectTypeBySubjectTypeId(Integer subjectTypeId);
}
