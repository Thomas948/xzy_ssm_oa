package com.xzy.service.impl;

import com.xzy.entity.Permission;
import com.xzy.mapper.PermissionMapper;
import com.xzy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/1
 * @time: 9:50
 * @description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Transactional(readOnly = true,rollbackFor = {Error.class,RuntimeException.class})
    @Override
    public Permission getPermissionByPermId(Integer permId) {
        return permissionMapper.getPermissionByPermId(permId);
    }

}
