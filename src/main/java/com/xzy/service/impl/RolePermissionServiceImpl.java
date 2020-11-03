package com.xzy.service.impl;

import com.xzy.entity.RolePermission;
import com.xzy.mapper.RolePermissionMapper;
import com.xzy.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 10:19
 * @description:
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Transactional(readOnly = true,rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public List<RolePermission> getRolePermissionsByRoleId(Integer roleId) {
        return rolePermissionMapper.getRolePermissionsByRoleId(roleId);
    }
}
