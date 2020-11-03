package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Student;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:52
 * @description:
 */
public interface StudentService {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByStudentId(Integer studentId);

    Student getStudentByStudentId(Integer studentId);

    List<Student> getStudentList();

    Page getStudents(int pageNum, int pageSize);

    Student getStudentByEmail(String stuEmail);
}
