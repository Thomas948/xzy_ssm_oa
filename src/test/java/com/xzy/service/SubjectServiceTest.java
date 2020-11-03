package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Subject;
import com.xzy.entity.SubjectType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:08
 * @description:
 */
public class SubjectServiceTest extends BaseTest {

    @Autowired
    private SubjectService subjectService;

    @Test
    public void addSubject() {
        Subject subject = new Subject(null, "php", 22, new Date(), new SubjectType(1));
        subjectService.addSubject(subject);
    }

    @Test
    public void updateSubject() {
        Subject subject = new Subject(6, "ruby", 21, new Date(), new SubjectType(4));
        subjectService.updateSubject(subject);
    }

    @Test
    public void deleteSubjectBySubjectId() {
        subjectService.deleteSubjectBySubjectId(4);
    }

    @Test
    public void getSubjectBySubjectId() {
        System.out.println(subjectService.getSubjectBySubjectId(6));
    }

    @Test
    public void getSubjectList() {
    }

    @Test
    public void getSubjects() {
        System.out.println(subjectService.getSubjects(1,5));
    }
}