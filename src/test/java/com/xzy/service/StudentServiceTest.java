package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:54
 * @description:
 */
public class StudentServiceTest extends BaseTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void addStudent() {
        /*Student student = new Student(null, "牛魔王", new Classes(3), "男", "17784655461", "1546416", "nmw@1.com", "魔王学校", new Education(3), new Date(), new Date(), new Employee(21), "511025199916354613");
        studentService.addStudent(student);*/
    }

    @Test
    public void updateStudent() {
        /*Student student = new Student(31, "白骨精", new Classes(2), "女", "17784653333", "15464163", "bgj@1.com", "西游学校", new Education(2), new Date(), new Date(), new Employee(2), "511025199816354610");
        studentService.updateStudent(student);*/
    }

    @Test
    public void deleteStudentByStudentId() {
        studentService.deleteStudentByStudentId(30);
    }

    @Test
    public void getStudentByStudentId() {
        System.out.println(studentService.getStudentByStudentId(31));
    }

    @Test
    public void getStudentList() {
    }

    @Test
    public void getStudents() {
        System.out.println(studentService.getStudents(9,2));
    }

    @Test
    public void getStudentByEmail() {
        System.out.println(studentService.getStudentByEmail("nmw@2.com"));
    }
}