package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.AttendanceExcel;
import com.xzy.dto.Page;
import com.xzy.entity.Attendance;
import com.xzy.entity.WorkType;
import com.xzy.service.AttendanceService;
import com.xzy.service.WorkTypeService;
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
 * @time: 10:27
 * @description:
 */
@RequestMapping("/attendance")
@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private WorkTypeService workTypeService;

    @RequestMapping("/approval/{attendanceId}/{status}")
    public String approval(@PathVariable("attendanceId") Integer attendanceId, @PathVariable("status") Integer status) {
        Attendance attendance = new Attendance(attendanceId, status);
        attendanceService.updateAttendance(attendance);
        return "redirect:/attendance/toList";
    }

    @RequestMapping("/delete/{attendanceId}")
    public String deleteAttendance(@PathVariable("attendanceId") Integer attendanceId) {
        attendanceService.deleteAttendanceByAttendanceId(attendanceId);
        return "redirect:/attendance/toMyAttendance";
    }

    @RequestMapping("/update")
    public String updateAttendance(Attendance attendance) {
        attendanceService.updateAttendance(attendance);
        return "redirect:/attendance/toMyAttendance";
    }

    @RequestMapping("/toUpdate/{attendanceId}")
    public String toUpdateAttendance(@PathVariable("attendanceId") Integer attendanceId, Model model) {
        Attendance attendance = attendanceService.getAttendanceByAttendanceId(attendanceId);
        model.addAttribute("attendance", attendance);
        List<WorkType> workTypes = workTypeService.getWorkTypes();
        model.addAttribute("workTypes", workTypes);
        return "work_update";
    }

    @RequestMapping("/add")
    public String addAttendance(Attendance attendance) {
        attendanceService.addAttendance(attendance);
        return "redirect:/attendance/toMyAttendance";
    }

    @RequestMapping("/toAdd")
    public String toAddAttendance(Model model) {
        List<WorkType> workTypes = workTypeService.getWorkTypes();
        model.addAttribute("workTypes", workTypes);
        return "work_add";
    }

    @RequestMapping("/downloadMyRecords/{empId}")
    public void downloadMyRecords(@PathVariable("empId") Integer empId, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("myRecords", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<AttendanceExcel> data = new ArrayList<>();
        List<Attendance> myRecords = attendanceService.getAttendanceByEmpId(empId);

        for (Attendance a : myRecords) {
            AttendanceExcel ael = new AttendanceExcel();

            ael.setWorkType(a.getWorkType().getWorkTypeName());
            ael.setApplicant(a.getApplicant().getEmpName());
            ael.setStartTime(a.getStartTime());
            ael.setEndTime(a.getEndTime());
            ael.setDays(a.getDays());
            ael.setAttendanceId(a.getAttendanceId());

            data.add(ael);
        }
        EasyExcel.write(response.getOutputStream(), AttendanceExcel.class).sheet("我的记录").doWrite(data);
    }

    @RequestMapping("/download")
    public void downloadAttendances(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("attendances", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<AttendanceExcel> data = new ArrayList<>();
        List<Attendance> attendances = attendanceService.getAttendanceList();

        for (Attendance a : attendances) {
            AttendanceExcel ael = new AttendanceExcel();

            ael.setWorkType(a.getWorkType().getWorkTypeName());
            ael.setStartTime(a.getStartTime());
            ael.setApplicant(a.getApplicant().getEmpName());
            ael.setEndTime(a.getEndTime());
            ael.setDays(a.getDays());
            ael.setAttendanceId(a.getAttendanceId());

            data.add(ael);
        }
        EasyExcel.write(response.getOutputStream(), AttendanceExcel.class).sheet("出勤信息").doWrite(data);

    }

    @ResponseBody
    @RequestMapping("/getMyAttendance/{empId}")
    public List<Attendance> getMyAttendance(@PathVariable("empId") Integer empId) {
        return attendanceService.getAttendanceByEmpId(empId);
    }

    @RequestMapping("/toMyAttendance")
    public String toMyAttendance() {
        return "work_my_list";
    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getAttendancePage(int pageNum, int pageSize) {
        return attendanceService.getAttendances(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toAttendanceList() {
        return "work_list";
    }

}
