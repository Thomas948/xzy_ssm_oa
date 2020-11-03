package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:34
 * @description:
 */
@Data
public class ClassesExcel {


    @ExcelProperty("序号")
    private Integer classId;
    @ExcelProperty("班级名称")
    private String className;
    @ExcelProperty("学科名称")
    private String subject;
    @ExcelProperty("班级人数")
    private Integer classCount;
    @ExcelProperty("周数")
    private Integer classLife;
    @ExcelProperty("地址")
    private String classAddress;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("开班日期")
    private Date createTime;

}
