package com.xzy.service;

import com.xzy.entity.Permission;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:49
 * @description:
 */
public interface PermissionService {

    /**
     * 根据id查权限信息
     * @param permId 要查的权限id
     * @return 返回权限信息
     */
    Permission getPermissionByPermId(Integer permId);
}
