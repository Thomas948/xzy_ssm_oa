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
 * @time: 19:39
 * @description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {

    private Integer subjectId;
    private String subjectName;
    private Integer subjectLife;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    private SubjectType subjectType;

    public Subject(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
