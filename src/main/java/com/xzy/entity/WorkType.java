package com.xzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:46
 * @description:
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkType {

    private Integer workTypeId;
    private String workTypeName;

    public WorkType(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }
}
