package com.xzy.entity;

import lombok.Data;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:44
 * @description:
 */
@Data
public class RolePermission {

    private Integer rpId;
    private Integer roleId;
    private Integer permId;

}
