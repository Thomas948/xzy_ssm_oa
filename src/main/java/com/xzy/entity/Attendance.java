package com.xzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:52
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendance {

    private Integer attendanceId;
    private Employee applicant;
    private WorkType workType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;
    private Integer days;
    private String reason;
    private Integer resultStatus;


    public Attendance(Integer attendanceId, Integer resultStatus) {
        this.attendanceId = attendanceId;
        this.resultStatus = resultStatus;
    }
}
