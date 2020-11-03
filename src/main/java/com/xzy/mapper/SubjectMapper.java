package com.xzy.mapper;

import com.xzy.entity.Subject;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:41
 * @description:
 */
public interface SubjectMapper {

    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubjectBySubjectId(Integer subjectId);

    Subject getSubjectBySubjectId(Integer subjectId);

    List<Subject> getSubjectList();
}
