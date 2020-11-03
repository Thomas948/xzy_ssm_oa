package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Classes;
import com.xzy.entity.Subject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:45
 * @description:
 */
public class ClassesServiceTest extends BaseTest {

    @Autowired
    private ClassesService classesService;

    @Test
    public void addClass() {
        Classes classes = new Classes(null, "zz班", new Subject(2), 100, 22, "南京", new Date());
        classesService.addClass(classes);
    }

    @Test
    public void updateClass() {
        Classes classes = new Classes(5, "zb班", new Subject(3), 99, 21, "南京市", new Date());
        classesService.updateClass(classes);
    }

    @Test
    public void deleteClassByClassId() {
        classesService.deleteClassByClassId(5);
    }

    @Test
    public void getClassByClassId() {
        System.out.println(classesService.getClassByClassId(5));
    }

    @Test
    public void getClassList() {
    }

    @Test
    public void getClassesPage() {
        System.out.println(classesService.getClassesPage(1,3));
    }
}