package com.xzy.mapper;

import com.xzy.entity.RolePermission;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:55
 * @description:
 */
public interface RolePermissionMapper {

    /**
     * 根据角色id查询权限信息
     * @param roleId 要查询的角色id
     * @return 返回该角色对应的权限关系表
     */
    List<RolePermission> getRolePermissionsByRoleId(Integer roleId);

}
