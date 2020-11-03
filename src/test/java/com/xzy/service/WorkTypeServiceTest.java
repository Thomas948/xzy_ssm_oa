package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:54
 * @description:
 */
public class WorkTypeServiceTest extends BaseTest {

    @Autowired
    private WorkTypeService workTypeService;

    @Test
    public void getWorkTypes() {
        System.out.println(workTypeService.getWorkTypes());
    }
}