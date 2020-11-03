package com.xzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 17:43
 * @description: 映射数据库部门表
 */

@NoArgsConstructor
@Data
public class Department {

    private Integer deptId;
    private String deptName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    public Department(Integer deptId) {
        this.deptId = deptId;
    }
}
