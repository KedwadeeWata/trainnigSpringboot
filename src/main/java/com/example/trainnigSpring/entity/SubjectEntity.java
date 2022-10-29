package com.example.trainnigSpring.entity;

import lombok.Data;

import javax.persistence.*;

@Data //แทน Getter and Setter
@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer subjectId;
    public String subjectName;
    public Integer credit;
    public String teacherName;


}
