package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Employee;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:08
 * @description:
 */
public interface EmployeeService {

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeByEmpId(Integer empId);

    Employee getEmployeeByEmpId(Integer empId);

    List<Employee> getEmployeeList();

    Page getEmployees(int pageNum, int pageSize);

    Employee getEmployeeByEmail(String email);
}
