package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xzy.dto.EmployeeExcel;
import com.xzy.dto.EmployeeExcel2;
import com.xzy.dto.Page;
import com.xzy.entity.*;
import com.xzy.service.DepartmentService;
import com.xzy.service.EmployeeService;
import com.xzy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 9:26
 * @description:
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteEmployeeByEmpId(employeeId);
        return "redirect:/employee/toList";
    }

    @RequestMapping("/update")
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employee/toList";
    }

    @RequestMapping("/toUpdate/{employeeId}")
    public String toUpdateEmployee(@PathVariable("employeeId") Integer employeeId, Model model) {
        Employee employee = employeeService.getEmployeeByEmpId(employeeId);
        model.addAttribute("employee", employee);
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        List<Role> roles = roleService.getRoleList();
        model.addAttribute("roles", roles);
        return "employee_update";

    }

    @RequestMapping("/add")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employee/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddEmployee(Model model) {
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        List<Role> roles = roleService.getRoleList();
        model.addAttribute("roles", roles);
        return "employee_add";
    }

    @RequestMapping("/import")
    public String importStudent(@RequestParam("file") MultipartFile excelFile) throws IOException {

        EasyExcel.read(excelFile.getInputStream(), EmployeeExcel2.class, new AnalysisEventListener<EmployeeExcel2>() {

            @Override
            public void invoke(EmployeeExcel2 data, AnalysisContext context) {
                Employee employee = new Employee();
                employee.setRole(new Role(data.getRole()));
                employee.setDept(new Department(data.getDept()));
                employee.setQq(data.getQq());
                employee.setHireTime(data.getHireTime());
                employee.setEmpPassword(data.getEmpPassword());
                employee.setEmpName(data.getEmpName());
                employee.setGender(data.getGender());
                employee.setPhone(data.getPhone());
                employee.setEmail(data.getEmail());
                employeeService.addEmployee(employee);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("导入完毕");
            }
        }).sheet().doRead();
        return "redirect:/employee/toList";
    }

    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("员工信息导入模板", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<EmployeeExcel2> data = new ArrayList<>();

        EasyExcel.write(response.getOutputStream(), EmployeeExcel2.class).sheet("员工信息").doWrite(data);
    }

    @RequestMapping("/download")
    public void downloadEmployees(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("employees", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<EmployeeExcel> data = new ArrayList<>();
        List<Employee> employees = employeeService.getEmployeeList();

        for (Employee emp : employees) {
            EmployeeExcel ecl = new EmployeeExcel();

            ecl.setEmpId(emp.getEmpId());
            ecl.setEmpName(emp.getEmpName());
            ecl.setGender(emp.getGender());
            ecl.setPhone(emp.getPhone());
            ecl.setQq(emp.getQq());
            ecl.setHireTime(emp.getHireTime());
            ecl.setDept(emp.getDept().getDeptName());
            ecl.setRole(emp.getRole().getRoleName());
            ecl.setEmpPassword(emp.getEmpPassword());
            ecl.setEmail(emp.getEmail());

            data.add(ecl);
        }
        EasyExcel.write(response.getOutputStream(), EmployeeExcel.class).sheet("员工信息").doWrite(data);

    }

    @RequestMapping("/toImport")
    public String toEmployeeImport() {
        return "employee_import";
    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getEmployeePage(int pageNum, int pageSize) {
        return employeeService.getEmployees(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toEmployeeList() {
        return "employee_list";
    }
}
