package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:50
 * @description:
 */
@Data
public class AttendanceExcel {

    @ExcelProperty("序号")
    private Integer attendanceId;
    @ExcelProperty("申请人")
    private String applicant;
    @ExcelProperty("操作类型")
    private String workType;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("起始时间")
    private Date startTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("结束时间")
    private Date endTime;
    @ExcelProperty("天数")
    private Integer days;

}
