package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 8:55
 * @description:
 */
@Data
public class RoleExcel {

    @ExcelProperty("角色编号")
    private Integer roleId;
    @ExcelProperty("角色名称")
    private String roleName;
    @ExcelProperty("有/无效")
    private String status;
}
