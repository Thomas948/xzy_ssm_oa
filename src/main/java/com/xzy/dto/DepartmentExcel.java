package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:55
 * @description:
 */
@Data
public class DepartmentExcel {

    @ExcelProperty("部门编号")
    private Integer deptId;
    @ExcelProperty("部门名称")
    private String deptName;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("创建时间")
    private Date createTime;
}
