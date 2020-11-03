package com.xzy.job;

import com.xzy.service.AttendanceService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/2
 * @time: 10:13
 * @description:
 */
public class AttendanceEndJob implements Job {

    @Autowired
    private AttendanceService attendanceService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("任务被执行了,时间为:"+sdf.format(new Date()));

        attendanceService.updateStatus();
    }
}
