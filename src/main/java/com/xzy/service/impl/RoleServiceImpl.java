package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Role;
import com.xzy.mapper.RoleMapper;
import com.xzy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:25
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class,Error.class})
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRoleByRoleId(Integer roleId) {
        roleMapper.deletRoleByRoleId(roleId);
    }

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoles();
    }

    @Override
    public Page getRoles(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleMapper.getRoles();
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        page.setPageNum(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setPages(pageInfo.getPages());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        return roleMapper.getRoleByRoleId(roleId);
    }
}
