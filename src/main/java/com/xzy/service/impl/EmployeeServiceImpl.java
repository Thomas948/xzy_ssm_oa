package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Employee;
import com.xzy.mapper.EmployeeMapper;
import com.xzy.service.EmployeeService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:09
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        //生成salt
        String salt = Math.random() + employee.getEmail();
        //Md5加密
        Md5Hash md5Hash = new Md5Hash(employee.getEmpPassword(), salt, 1024);
        //生成加密之后新密码
        String newPassword = md5Hash.toString();
        employee.setEmpPassword(newPassword);
        employee.setSalt(salt);
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employee.getEmpPassword() != null && employee.getEmpPassword().length() > 0) {
            String salt = Math.random() + employee.getEmail();
            Md5Hash md5Hash = new Md5Hash(employee.getEmpPassword(), salt, 1024);
            String newPassword = md5Hash.toString();
            employee.setEmpPassword(newPassword);
            employee.setSalt(salt);
        }
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployeeByEmpId(Integer empId) {
        employeeMapper.deleteEmployeeByEmpId(empId);
    }

    @Override
    public Employee getEmployeeByEmpId(Integer empId) {
        return employeeMapper.getEmployeeByEmpId(empId);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    @Override
    public Page getEmployees(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        page.setPageNum(pageInfo.getPageNum());
        page.setPages(pageInfo.getPages());
        page.setPageSize(pageInfo.getPageSize());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeMapper.getEmployeeByEmail(email);
    }
}
