package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 9:03
 * @description:
 */
@Data
public class StudentExcel {
    @ExcelProperty("学号")
    private Integer studentId;
    @ExcelProperty("学员名称")
    private String studentName;
    @ExcelProperty("所在班级")
    private String className;
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
    @ExcelProperty("招生老师")
    private String teacher;
    @ExcelProperty("学历")
    private String education;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("出生日期")
    private Date createTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("日学日期")
    private Date inTime;

}
