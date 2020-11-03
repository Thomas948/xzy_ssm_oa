package com.xzy.mapper;

import com.xzy.entity.Role;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:12
 * @description:
 */
public interface RoleMapper {

    void addRole(Role role);

    void updateRole(Role role);

    void deletRoleByRoleId(Integer roleId);

    List<Role> getRoles();

    Role getRoleByRoleId(Integer roleId);
}
