package com.example.trainnigSpring.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Data //แทน Getter and Setter
@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer secClass;
    private Integer numberStudentClass;

}
