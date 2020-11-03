package com.xzy.service;

import com.xzy.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 10:20
 * @description:
 */
public class RolePermissionServiceTest extends BaseTest {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void getRolePermissionsByRoleId() {
        System.out.println(rolePermissionService.getRolePermissionsByRoleId(10000));
    }
}