package com.xzy.realms;

import com.xzy.entity.Employee;
import com.xzy.entity.Permission;
import com.xzy.entity.RolePermission;
import com.xzy.service.EmployeeService;
import com.xzy.service.PermissionService;
import com.xzy.service.RolePermissionService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 22:35
 * @description:
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户名
        String username = principal.getPrimaryPrincipal().toString();
        //查角色
        Employee employee = employeeService.getEmployeeByEmail(username);

        Set<String> role = new HashSet<>();
        role.add(employee.getRole().getRoleName());

        List<RolePermission> rps = rolePermissionService.getRolePermissionsByRoleId(employee.getRole().getRoleId());
        Set<String> perms = new HashSet<>();
        for (RolePermission rp : rps) {
            Permission perm = permissionService.getPermissionByPermId(rp.getPermId());
            perms.add(perm.getPermName());
        }

        info.addStringPermissions(perms);
        info.setRoles(role);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的登录名
        String username = (String) token.getPrincipal();
        if (username == null || username.length() <= 0) {
            throw new AuthenticationException("用户名为空");
        }
        //从数据库查询数据
        Employee employee = employeeService.getEmployeeByEmail(username);
        //构建盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(employee.getSalt());
        return new SimpleAuthenticationInfo(employee.getEmail(), employee.getEmpPassword(), credentialsSalt, getName());
    }
}
