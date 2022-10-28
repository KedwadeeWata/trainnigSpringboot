package com.example.trainnigSpring.model;

import lombok.Data;

@Data
public class ScheduleResponse {
    private StudentRequest studentId;
    private  ClassRequest classId;
    private SubjectRequest subjectId;
}
