package com.xzy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:10
 * @description:
 */
@NoArgsConstructor
@Data
public class Role {

    private Integer roleId;
    private String roleName;
    private String status;

    public Role(Integer roleId) {
        this.roleId = roleId;
    }
}
