package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;


/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:13
 * @description:
 */
@Data
public class EmployeeExcel2 {

    @ExcelProperty("员工名称")
    private String empName;
    @ExcelProperty("角色序号")
    private Integer role;
    @ExcelProperty("部门序号")
    private Integer dept;
    @ExcelProperty("性别")
    private String gender;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("qq")
    private String qq;
    @ExcelProperty("邮箱")
    private String email;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("入职时间")
    private Date hireTime;
    @ExcelProperty("密码")
    private String empPassword;

}
