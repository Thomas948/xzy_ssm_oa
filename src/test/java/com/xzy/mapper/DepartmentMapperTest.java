package com.xzy.mapper;

import com.xzy.BaseTest;
import com.xzy.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:02
 * @description:
 */


public class DepartmentMapperTest extends BaseTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDeptName("人事部");
        department.setCreateTime(new Date());
        departmentMapper.addDepartment(department);
    }

    @Test
    public void getDepartments() {

        System.out.println(departmentMapper.getDepartments());
    }
}