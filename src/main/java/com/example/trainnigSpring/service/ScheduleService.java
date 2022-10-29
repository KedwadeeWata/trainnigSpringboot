package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.ClassEntity;
import com.example.trainnigSpring.entity.ScheduleEntity;
import com.example.trainnigSpring.entity.StudentEntity;
import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.*;
import com.example.trainnigSpring.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    StudentService StudentService;

    @Autowired
    ClassService ClassService;

    @Autowired
    SubjectService SubjectService;

    public ScheduleResponse add(ScheduleRequest scheduleRequest) {

        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setStudentId(scheduleRequest.getStudentId());
        scheduleEntity.setClassId(scheduleRequest.getClassId());
        scheduleEntity.setSubjectId(scheduleRequest.getSubjectId());
        scheduleRepository.save(scheduleEntity);

        ScheduleResponse scheduleResponse = new ScheduleResponse();

        StudentRequest studentRequest = new StudentRequest();
        StudentEntity studentEntity = StudentService.getById(scheduleRequest.getStudentId());
        studentRequest.setStudentFirstName(studentEntity.getStudentFirstName());
        studentRequest.setStudentLastName(studentEntity.getStudentLastName());
        studentRequest.setStudentClass(studentEntity.getStudentClass());
        scheduleResponse.setStudentId(studentRequest);

        ClassRequest classRequest = new ClassRequest();
        ClassEntity classEntity = ClassService.getById(scheduleRequest.getClassId());
        classRequest.setSecClass(classEntity.getSecClass());
        classRequest.setNumberStudentClass(classEntity.getNumberStudentClass());
        scheduleResponse.setClassId(classRequest);

        SubjectRequest subjectRequest = new SubjectRequest();
        SubjectEntity subjectEntity = SubjectService.getById(scheduleRequest.getSubjectId());
        subjectRequest.setSubjectName(subjectEntity.getSubjectName());
        subjectRequest.setCredit(subjectEntity.getCredit());
        subjectRequest.setTeacherName(subjectEntity.getTeacherName());
        scheduleResponse.setSubjectId(subjectRequest);

        return scheduleResponse;





    }
   /* public List<ScheduleEntity> getAll(){
        return scheduleRepository.findAll();
    }
    public ScheduleEntity getById(Integer id){
        return scheduleRepository.findById(id).get();
    }

    public ScheduleResponse edit(Integer id,ScheduleRequest scheduleRequest ){
        if(scheduleRequest.findId(id).get() == null){
            throw new Exception();
throw new IOException("null id");

        }
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setStudentId(null);
        scheduleEntity.setStudentName(scheduleRequest.getStudentName());
        scheduleEntity.setSubjectId(scheduleRequest.getSubjectId());
        scheduleEntity.setSubjectName(scheduleRequest.getSubjectName());
        return scheduleRepository.edit(id,subjectRequest);

    }
    public void delete(Integer id) {
        scheduleRepository.deleteById(id);
    }*/


    }
