package com.xzy.mapper;

import com.xzy.entity.Student;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:30
 * @description:
 */
public interface StudentMapper {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByStudentId(Integer studentId);

    Student getStudentByStudentId(Integer studentId);

    List<Student> getStudentList();

    Student getStudentByEmail(String stuEmail);
}
