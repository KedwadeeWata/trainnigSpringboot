package com.example.trainnigSpring.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Data //แทน Getter and Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentFirstName;
    private String studentLastname;
    private String studentClass;
}
