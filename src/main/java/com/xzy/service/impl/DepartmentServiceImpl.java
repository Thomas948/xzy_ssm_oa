package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Department;
import com.xzy.mapper.DepartmentMapper;
import com.xzy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:08
 * @description:
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void deleteDepartmentByDeptId(Integer deptId) {
        departmentMapper.deleteDepartmentByDeptId(deptId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public Department getDepartmentByDeptId(Integer deptId) {
        return departmentMapper.getDepartmentByDeptId(deptId);
    }

    @Transactional(readOnly = true,rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }

    @Override
    public Page getDepartmentPage(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Department> departments = departmentMapper.getDepartments();
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        page.setPageSize(pageInfo.getPageSize());
        page.setPageNum(pageInfo.getPageNum());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setPages(pageInfo.getPages());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }
}
