package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.StudentEntity;
import com.example.trainnigSpring.model.StudentRequest;
import com.example.trainnigSpring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService implements StudentServiceln{
    @Autowired
    StudentRepository studentRepository;

    public StudentEntity add(StudentRequest studentRequest){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(null);
        studentEntity.setStudentFirstName(studentRequest.getStudentFirstName());
        studentEntity.setStudentLastname(studentRequest.getStudentLastName());
        studentEntity.setStudentClass(studentRequest.getStudentClass());
        return studentRepository.save(studentEntity);

    }
    public List<StudentEntity> getAll(){
        return studentRepository.findAll();
    }
    public StudentEntity getById(Integer id){
        return studentRepository.findById(id).get();
    }

    public StudentEntity edit(Integer id,StudentRequest studentRequest ) throws Exception{
        if(studentRepository.findById(id).get() == null){
            throw new Exception();
            /*throw new IOException("null id");*/
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(null);
        studentEntity.setStudentFirstName(studentRequest.getStudentFirstName());
        studentEntity.setStudentLastname(studentRequest.getStudentLastName());
        studentEntity.setStudentClass(studentRequest.getStudentClass());
        return studentRepository.save(studentEntity);

    }
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }


}
