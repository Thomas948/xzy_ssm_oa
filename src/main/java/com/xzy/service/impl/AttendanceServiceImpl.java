package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Attendance;
import com.xzy.mapper.AttendanceMapper;
import com.xzy.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 21:32
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public void addAttendance(Attendance attendance) {
        attendanceMapper.addAttendance(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendanceByAttendanceId(Integer attendanceId) {
        attendanceMapper.deleteAttendanceByAttendanceId(attendanceId);
    }

    @Override
    public Attendance getAttendanceByAttendanceId(Integer attendanceId) {
        return attendanceMapper.getAttendanceByAttendanceId(attendanceId);
    }

    @Override
    public List<Attendance> getAttendanceByEmpId(Integer empId) {
        return attendanceMapper.getAttendanceByEmpId(empId);
    }

    @Override
    public List<Attendance> getAttendanceList() {
        return attendanceMapper.getAttendanceList();
    }

    @Override
    public Page getAttendances(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Attendance> attendanceList = attendanceMapper.getAttendanceList();
        PageInfo<Attendance> pageInfo = new PageInfo<>(attendanceList);
        page.setPages(pageInfo.getPages());
        page.setPageNum(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }

    @Override
    public void updateStatus() {
        attendanceMapper.updateStatus();
    }
}
