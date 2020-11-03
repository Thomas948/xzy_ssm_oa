package com.xzy.mapper;

import com.xzy.entity.Employee;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 21:46
 * @description:
 */
public interface EmployeeMapper {

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeByEmpId(Integer empId);

    Employee getEmployeeByEmpId(Integer empId);

    List<Employee> getEmployeeList();

    Employee getEmployeeByEmail(String email);

}
