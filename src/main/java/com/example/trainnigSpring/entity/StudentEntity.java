package com.example.trainnigSpring.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Data //แทน Getter and Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    public String studentFirstName;
    public String studentLastName;
    public String studentClass;
}
