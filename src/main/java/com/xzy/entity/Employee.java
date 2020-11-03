package com.xzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:55
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {

    private Integer empId;
    private String empName;
    private String gender;
    private String phone;
    private String qq;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hireTime;
    private String empPassword;
    private String salt;
    private String icon;

    private Department dept;
    private Role role;

    public Employee(Integer empId) {
        this.empId = empId;
    }
}
