package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:45
 * @description:
 */
@Data
public class SubjectExcel {

    @ExcelProperty("序号")
    private Integer subjectId;
    @ExcelProperty("学科名称")
    private String subjectName;
    @ExcelProperty("学科周期")
    private Integer subjectLife;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("成立日期")
    private Date createTime;
    @ExcelProperty("学科类型")
    private String subjectType;
}
