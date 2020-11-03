package com.xzy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 18:55
 * @description:
 */

@NoArgsConstructor
@Data
public class SubjectType {

    private Integer subjectTypeId;
    private String subjectTypeName;

    public SubjectType(Integer subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }
}
