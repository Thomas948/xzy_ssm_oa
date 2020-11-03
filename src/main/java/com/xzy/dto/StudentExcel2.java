package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 15:10
 * @description:
 */
@Data
public class StudentExcel2 {

    @ExcelProperty("学员名称")
    private String studentName;
    @ExcelProperty("所在班级序号")
    private Integer classId;
    @ExcelProperty("性别")
    private String stuGender;
    @ExcelProperty("手机号")
    private String stuPhone;
    @ExcelProperty("邮箱")
    private String stuEmail;
    @ExcelProperty("QQ")
    private String stuQq;
    @ExcelProperty("身份证号")
    private String cardNum;
    @ExcelProperty("毕业院校")
    private String graduateSchool;
    @ExcelProperty("招生老师员工号")
    private Integer teacher;
    @ExcelProperty("学历")
    private Integer education;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("出生日期")
    private Date createTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("入学日期")
    private Date inTime;

}
