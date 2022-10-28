package com.example.trainnigSpring.model;

import lombok.Data;

@Data
public class ScheduleRequest {
    private Integer studentId;
    private  Integer classId;
    private Integer subjectId;
}
