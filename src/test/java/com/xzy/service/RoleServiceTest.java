package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:31
 * @description:
 */
public class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName("超管");
        role.setStatus("禁用");
        roleService.addRole(role);
    }

    @Test
    public void updateRole() {
        Role role = new Role();
        role.setRoleId(10008);
        role.setRoleName("超管1");
        role.setStatus("有效");
        roleService.updateRole(role);
    }

    @Test
    public void deleteRoleByRoleId() {
        roleService.deleteRoleByRoleId(10008);
    }

    @Test
    public void getRoleList() {
    }

    @Test
    public void getRoles() {
        System.out.println(roleService.getRoles(1,5));
    }

    @Test
    public void getRoleByRoleId() {
        System.out.println(roleService.getRoleByRoleId(10005));
    }
}