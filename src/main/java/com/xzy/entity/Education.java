package com.xzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:03
 * @description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Education {

    private Integer educationId;
    private String educationName;

    public Education(Integer educationId) {
        this.educationId = educationId;
    }
}
