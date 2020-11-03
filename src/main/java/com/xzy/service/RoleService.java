package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Role;

import java.util.List;


/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:22
 * @description:
 */
public interface RoleService {

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRoleByRoleId(Integer roleId);

    List<Role> getRoleList();

    Page getRoles(int pageNum, int pageSize);

    Role getRoleByRoleId(Integer roleId);
}
