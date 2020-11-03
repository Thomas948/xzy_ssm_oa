package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Subject;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:03
 * @description:
 */
public interface SubjectService {

    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubjectBySubjectId(Integer subjectId);

    Subject getSubjectBySubjectId(Integer subjectId);

    List<Subject> getSubjectList();

    Page getSubjects(int pageNum, int pageSize);
}
