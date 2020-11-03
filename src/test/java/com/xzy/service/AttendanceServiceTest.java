package com.xzy.service;

import com.xzy.BaseTest;
import com.xzy.entity.Attendance;
import com.xzy.entity.Employee;
import com.xzy.entity.WorkType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 21:35
 * @description:
 */
public class AttendanceServiceTest extends BaseTest {

    @Autowired
    private AttendanceService attendanceService;

    @Test
    public void addAttendance() {
        /*Attendance attendance = new Attendance(null, new Employee(1), new WorkType(2), new Date(), new Date(), 1, "进行中");
        attendanceService.addAttendance(attendance);*/
    }

    @Test
    public void updateAttendance() {
        /*Attendance attendance = new Attendance(2, new Employee(5), new WorkType(3), new Date(), new Date(), 2, "完成");
        attendanceService.updateAttendance(attendance);*/
    }

    @Test
    public void deleteAttendanceByAttendanceId() {
        attendanceService.deleteAttendanceByAttendanceId(2);
    }

    @Test
    public void getAttendanceByAttendanceId() {
        System.out.println(attendanceService.getAttendanceByAttendanceId(2));
    }

    @Test
    public void getAttendanceList() {
    }

    @Test
    public void getAttendances() {
        System.out.println(attendanceService.getAttendances(1, 2));
    }
}