package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Attendance;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 21:31
 * @description:
 */
public interface AttendanceService {

    void addAttendance(Attendance attendance);

    void updateAttendance(Attendance attendance);

    void deleteAttendanceByAttendanceId(Integer attendanceId);

    Attendance getAttendanceByAttendanceId(Integer attendanceId);

    List<Attendance> getAttendanceList();

    List<Attendance> getAttendanceByEmpId(Integer empId);

    Page getAttendances(int pageNum, int pageSize);

    void updateStatus();
}
