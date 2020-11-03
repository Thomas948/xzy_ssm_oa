package com.xzy.mapper;

import com.xzy.entity.Attendance;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 21:03
 * @description:
 */
public interface AttendanceMapper {

    void addAttendance(Attendance attendance);

    void updateAttendance(Attendance attendance);

    void deleteAttendanceByAttendanceId(Integer attendanceId);

    Attendance getAttendanceByAttendanceId(Integer attendanceId);

    List<Attendance> getAttendanceList();

    List<Attendance> getAttendanceByEmpId(Integer empId);

    void updateStatus();
}
