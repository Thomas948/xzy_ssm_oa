package com.xzy.mapper;

import com.xzy.entity.Permission;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:46
 * @description:
 */
public interface PermissionMapper {

    /**
     * 根据id查权限信息
     * @param permId 要查的权限id
     * @return 返回权限信息
     */
    Permission getPermissionByPermId(Integer permId);
}
