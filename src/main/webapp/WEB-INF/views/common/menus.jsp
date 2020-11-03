<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/30
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="${pageContext.request.contextPath}/toMain"><img
                src="${pageContext.request.contextPath}/images/tiger.jpg" title="LightYear" alt="LightYear"/></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <shiro:guest><li class="nav-item active"><a href="${pageContext.request.contextPath}/login"><i
                        class="mdi mdi-home"></i>当前未登录,请先登录</a></li></shiro:guest>
                <shiro:user>
                    <li class="nav-item active"><a href="${pageContext.request.contextPath}/toMain"><i
                            class="mdi mdi-home"></i> 办公首页</a></li>
                    <shiro:hasPermission name="role_edit">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-image-filter-vintage"></i> 权限管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/role/toList">用户角色</a></li>
                                <li><a href="${pageContext.request.contextPath}/role/toAdd">添加角色</a></li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="att_read">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="#"><i class="mdi mdi-account-convert"></i> 考勤管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/attendance/toAdd">请假/调休</a></li>
                                <shiro:hasPermission name="att_edit">
                                    <li><a href="${pageContext.request.contextPath}/attendance/toList">申请列表</a></li>
                                </shiro:hasPermission>
                                <li><a href="${pageContext.request.contextPath}/attendance/toMyAttendance">我的记录</a></li>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="dept_read">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-counter"></i> 部门管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/dept/toList">部门列表</a></li>
                                <shiro:hasPermission name="dept_edit">
                                    <li><a href="${pageContext.request.contextPath}/dept/toAdd">新增部门</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="emp_read">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-account-settings"></i> 员工管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/employee/toList">员工列表</a></li>
                                <shiro:hasPermission name="emp_edit">
                                    <li><a href="${pageContext.request.contextPath}/employee/toAdd">员工新增</a></li>
                                    <li><a href="${pageContext.request.contextPath}/employee/toImport">员工导入</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="sub_read">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-shovel"></i> 学科管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/subject/toList">学科列表</a></li>
                                <shiro:hasPermission name="sub_edit">
                                    <li><a href="${pageContext.request.contextPath}/subject/toAdd">学科新增</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="class_read">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-face-profile"></i> 班级管理</a>
                            <ul class="nav nav-subnav">
                                <li><a href="${pageContext.request.contextPath}/classes/toList">班级列表</a></li>
                                <shiro:hasPermission name="class_edit">
                                    <li><a href="${pageContext.request.contextPath}/classes/toAdd">班级新增</a></li>
                                </shiro:hasPermission>
                            </ul>
                        </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="stu_read">
                    <li class="nav-item nav-item-has-subnav">
                        <a href="javascript:void(0)"><i class="mdi mdi-trophy-variant"></i> 学员管理</a>
                        <ul class="nav nav-subnav">
                            <li><a href="${pageContext.request.contextPath}/student/toList">学员列表</a></li>
                            <shiro:hasPermission name="stu_edit">
                            <li><a href="${pageContext.request.contextPath}/student/toAdd">学员新增</a></li>
                            <li><a href="${pageContext.request.contextPath}/student/toImport">学员导入</a></li></shiro:hasPermission>
                        </ul>
                    </li></shiro:hasPermission>

                </shiro:user>
            </ul>
        </nav>
        <div class="sidebar-footer">
            <p class="copyright">Copyright &copy; 2020. <img style="width: 25px;padding-bottom: 5px;"
                                                             src="${pageContext.request.contextPath}/images/fy.png"
                                                             alt="#"/> <a target="_blank"
                                                                          href="https://hd1611756908.github.io/">
                OA</a>&nbsp; Powered By &nbsp;<a href="https://space.bilibili.com/16364623" target="_blank"
                                                  title="半个橙子">半个橙子</a></p>
        </div>

    </div>

</aside>
