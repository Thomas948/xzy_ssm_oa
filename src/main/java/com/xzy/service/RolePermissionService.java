package com.xzy.service;

import com.xzy.entity.RolePermission;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 10:05
 * @description:
 */
public interface RolePermissionService {

    /**
     * 根据角色id查询权限信息
     * @param roleId 要查询的角色id
     * @return 返回该角色对应的权限关系表
     */
    List<RolePermission> getRolePermissionsByRoleId(Integer roleId);
}
