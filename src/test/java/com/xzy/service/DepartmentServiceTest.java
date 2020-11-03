package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:52
 * @description:
 */

public class DepartmentServiceTest extends BaseTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDeptName("产品部");
        department.setCreateTime(new Date());
        departmentService.addDepartment(department);
    }

    @Test
    public void update() {
        Department department = new Department();
        department.setDeptName("产品部2");
        department.setCreateTime(new Date());
        department.setDeptId(10);
        departmentService.updateDepartment(department);
    }

    @Test
    public void delete() {
        departmentService.deleteDepartmentByDeptId(10);
    }

    @Test
    public void getSingle() {
        System.out.println(departmentService.getDepartmentByDeptId(10));
    }

    @Test
    public void getPage() {
        System.out.println(departmentService.getDepartmentPage(1, 5));
    }

    @Test
    public void getDepartments() {
        System.out.println(departmentService.getDepartments());
    }
}