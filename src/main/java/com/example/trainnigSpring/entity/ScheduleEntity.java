package com.example.trainnigSpring.entity;

import lombok.Data;

import javax.persistence.*;

@Data //แทน Getter and Setter
@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private Integer classId;
    private Integer subjectId;

}
