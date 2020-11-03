package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Department;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:06
 * @description:
 */

public interface DepartmentService {

    /**
     * 新增部门
     * @param department 要新增的部门
     */
    void addDepartment(Department department);

    void deleteDepartmentByDeptId(Integer deptId);

    void updateDepartment(Department department);

    Department getDepartmentByDeptId(Integer deptId);

    List<Department> getDepartments();

    Page getDepartmentPage(int pageNum, int pageSize);
}
