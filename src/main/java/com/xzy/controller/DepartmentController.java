package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.DepartmentExcel;
import com.xzy.dto.Page;
import com.xzy.entity.Department;
import com.xzy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 10:06
 * @description:
 */
@Controller
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/delete/{deptId}")
    public String deleteDepartment(@PathVariable("deptId") Integer deptId) {
        departmentService.deleteDepartmentByDeptId(deptId);
        return "redirect:/dept/toList";
    }

    @RequestMapping("/update")
    public String updateDepartment(Department dept) {
        departmentService.updateDepartment(dept);
        return "redirect:/dept/toList";
    }

    @RequestMapping("/toUpdate/{deptId}")
    public String toUpdateDepartment(@PathVariable("deptId") Integer deptId, Model model) {
        Department department = departmentService.getDepartmentByDeptId(deptId);
        model.addAttribute("dept", department);
        return "dept_update";
    }

    @RequestMapping("/add")
    public String addDepartment(Department dept) {
        departmentService.addDepartment(dept);
        return "redirect:/dept/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddDepartment() {
        return "dept_add";
    }

    @RequestMapping("/download")
    public void downloadDepartments(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("departments", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<DepartmentExcel> data = new ArrayList<>();
        List<Department> departments = departmentService.getDepartments();

        for (Department dept : departments) {
            DepartmentExcel dcl = new DepartmentExcel();

            dcl.setDeptName(dept.getDeptName());
            dcl.setDeptId(dept.getDeptId());
            dcl.setCreateTime(dept.getCreateTime());

            data.add(dcl);
        }
        EasyExcel.write(response.getOutputStream(), DepartmentExcel.class).sheet("部门信息").doWrite(data);

    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getDepartmentPage(int pageNum, int pageSize) {
        return departmentService.getDepartmentPage(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toDepartmentList() {
        return "dept_list";
    }
}
