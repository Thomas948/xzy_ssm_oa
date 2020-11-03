package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:51
 * @description:
 */
public class PermissionServiceTest extends BaseTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void getPermissionByPermId() {

        System.out.println(permissionService.getPermissionByPermId(11));
    }
}