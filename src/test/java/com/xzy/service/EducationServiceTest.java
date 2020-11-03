package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:07
 * @description:
 */
public class EducationServiceTest extends BaseTest {


    @Autowired
    private EducationService educationService;
    @Test
    public void getEducationList() {

        System.out.println(educationService.getEducationList());
    }
}