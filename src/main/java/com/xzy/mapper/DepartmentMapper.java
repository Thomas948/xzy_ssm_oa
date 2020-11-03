package com.xzy.mapper;

import com.xzy.entity.Department;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 17:44
 * @description:
 */
public interface DepartmentMapper {

    /**
     * 新增部门
     * @param department 要新增的部门
     */
    void addDepartment(Department department);

    void deleteDepartmentByDeptId(Integer deptId);

    void updateDepartment(Department department);

    Department getDepartmentByDeptId(Integer deptId);

    List<Department> getDepartments();
}
