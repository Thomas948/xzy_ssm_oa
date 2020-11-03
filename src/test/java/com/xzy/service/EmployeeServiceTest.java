package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Department;
import com.xzy.entity.Employee;
import com.xzy.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:11
 * @description:
 */
public class EmployeeServiceTest extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void addEmployee() {
        /*Employee employee = new Employee(null, "孙悟空", new Department(3), "男", "15963663345", "4866542", "swk@1.com", new Date(), "swk", new Role(10000));
        employeeService.addEmployee(employee);*/
    }

    @Test
    public void updateEmployee() {
        /*Employee employee = new Employee(14, "孙行者", new Department(3), "男", "15963663345", "4866542", "sxz@1.com", new Date(), "sxz", new Role(10002));
        employeeService.updateEmployee(employee);*/
    }

    @Test
    public void deleteEmployeeByEmpId() {
        employeeService.deleteEmployeeByEmpId(15);
    }

    @Test
    public void getEmployeeByEmpId() {
        System.out.println(employeeService.getEmployeeByEmpId(22));
    }

    @Test
    public void getEmployeeList() {
    }

    @Test
    public void getEmployees() {
        System.out.println(employeeService.getEmployees(1, 3));
    }

    @Test
    public void getEmployeeByEmail() {
        System.out.println(employeeService.getEmployeeByEmail("xz@1.com"));
    }
}