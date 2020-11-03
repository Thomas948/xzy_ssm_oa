package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Role;
import com.xzy.entity.Subject;
import com.xzy.mapper.SubjectMapper;
import com.xzy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:04
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void addSubject(Subject subject) {
        subjectMapper.addSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectMapper.updateSubject(subject);
    }

    @Override
    public void deleteSubjectBySubjectId(Integer subjectId) {
        subjectMapper.deleteSubjectBySubjectId(subjectId);
    }

    @Override
    public Subject getSubjectBySubjectId(Integer subjectId) {
        return subjectMapper.getSubjectBySubjectId(subjectId);
    }

    @Override
    public List<Subject> getSubjectList() {
        return subjectMapper.getSubjectList();
    }

    @Override
    public Page getSubjects(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Subject> subjectList = subjectMapper.getSubjectList();
        PageInfo<Subject> pageInfo = new PageInfo<>(subjectList);
        page.setPageSize(pageInfo.getPageSize());
        page.setPageNum(pageInfo.getPageNum());
        page.setPages(pageInfo.getPages());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }
}
