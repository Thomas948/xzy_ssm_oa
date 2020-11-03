package com.xzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 22:24
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private Integer studentId;
    private String studentName;
    private Classes classes;
    private String stuGender;
    private String stuPhone;
    private String stuQq;
    private String stuEmail;
    private String graduateSchool;
    private Education education;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inTime;
    private Employee teacher;
    private String cardNum;
}
