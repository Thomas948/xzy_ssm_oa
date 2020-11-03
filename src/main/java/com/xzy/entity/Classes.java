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
 * @time: 20:23
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classes {

    private Integer classId;
    private String className;
    private Subject subject;
    private Integer classCount;
    private Integer classLife;
    private String classAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    public Classes(Integer classId) {
        this.classId = classId;
    }
}
