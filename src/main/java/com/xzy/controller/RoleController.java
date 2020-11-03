package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.RoleExcel;
import com.xzy.dto.Page;
import com.xzy.entity.Role;
import com.xzy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 10:46
 * @description:
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/delete/{roleId}")
    public String deleteRole(@PathVariable("roleId") Integer roleId) {
        roleService.deleteRoleByRoleId(roleId);
        return "redirect:/role/toList";
    }

    @RequestMapping("/update")
    public String updateRole(Role role) {
        roleService.updateRole(role);
        return "redirect:/role/toList";
    }

    @RequestMapping("/toUpdate/{roleId}")
    public String toUpdateRole(@PathVariable("roleId") Integer roleId, Model model) {
        Role role = roleService.getRoleByRoleId(roleId);
        model.addAttribute("role", role);
        return "role_update";
    }

    @RequestMapping("/add")
    public String addRole(Role role) {
        roleService.addRole(role);
        return "redirect:/role/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddRole() {
        return "role_add";
    }

    @RequestMapping("/download")
    public void downloadRoles(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("roles", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<RoleExcel> data = new ArrayList<>();
        List<Role> roles = roleService.getRoleList();

        for (Role r : roles) {
            RoleExcel rel = new RoleExcel();

            rel.setRoleId(r.getRoleId());
            rel.setRoleName(r.getRoleName());
            rel.setStatus(r.getStatus());

            data.add(rel);
        }
        EasyExcel.write(response.getOutputStream(), RoleExcel.class).sheet("角色信息").doWrite(data);

    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getRolePage(int pageNum, int pageSize) {
        return roleService.getRoles(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toRoleList() {
        return "role_list";
    }
}
