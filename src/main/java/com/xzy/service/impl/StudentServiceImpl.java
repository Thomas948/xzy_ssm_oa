package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Student;
import com.xzy.mapper.StudentMapper;
import com.xzy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:52
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudentByStudentId(Integer studentId) {
        studentMapper.deleteStudentByStudentId(studentId);
    }

    @Override
    public Student getStudentByStudentId(Integer studentId) {
        return studentMapper.getStudentByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public Page getStudents(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentMapper.getStudentList();
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        page.setPageSize(pageInfo.getPageSize());
        page.setPageNum(pageInfo.getPageNum());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setPages(pageInfo.getPages());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }

    @Override
    public Student getStudentByEmail(String stuEmail) {
        return studentMapper.getStudentByEmail(stuEmail);
    }
}
