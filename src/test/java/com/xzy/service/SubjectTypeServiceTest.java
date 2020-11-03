package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:00
 * @description:
 */
public class SubjectTypeServiceTest extends BaseTest {

    @Autowired
    private SubjectTypeService subjectTypeService;

    @Test
    public void getSubjectTypes() {

        System.out.println(subjectTypeService.getSubjectTypes());
    }
}