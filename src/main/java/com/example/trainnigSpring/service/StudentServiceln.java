package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.StudentEntity;
import com.example.trainnigSpring.model.StudentRequest;

import java.util.List;

public interface StudentServiceln {
    StudentEntity add(StudentRequest studentRequest);
    List<StudentEntity> getAll();
    StudentEntity getById(Integer id);
    StudentEntity edit(Integer id,StudentRequest studentRequest ) throws Exception;
    void delete(Integer id);

}
