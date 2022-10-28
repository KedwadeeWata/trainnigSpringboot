package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.ClassEntity;
import com.example.trainnigSpring.entity.ScheduleEntity;
import com.example.trainnigSpring.entity.StudentEntity;
import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.ScheduleRequest;
import com.example.trainnigSpring.model.ScheduleResponse;
import com.example.trainnigSpring.model.StudentRequest;
import com.example.trainnigSpring.model.StudentResponse;
import com.example.trainnigSpring.repository.ClassRepository;
import com.example.trainnigSpring.repository.ScheduleRepository;
import com.example.trainnigSpring.repository.StudentRepository;
import com.example.trainnigSpring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.trainnigSpring.model.StudentRequest.*;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    StudentService StudentService;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    SubjectRepository subjectRepository;

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

        return scheduleResponse;
       /*
        ClassEntity classEntity = new ClassEntity();
        scheduleEntity.setClassId(scheduleService.getClassId());
        scheduleEntity.setSubjectId(scheduleService.getSubjectId());
        classRepository.save(classEntity);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(scheduleService.getSubjectId);
        subjectEntity.setCredit(scheduleService.getCredit);
        subjectEntity.setTeacherName(scheduleService.getTeacherName);
        subjectRepository.save(subjectEntity);*/



        /*return scheduleRespone;*/
 /*   }
    public List<ScheduleEntity> getAll(){
        return scheduleRepository.findAll();
    }
    public ScheduleEntity getById(Integer id){
        return scheduleRepository.findById(id).get();
    }

    public ScheduleEntity edit(Integer id,ScheduleRequest scheduleRequest ) throws Exception{
        if(scheduleRequest.findId(id).get() == null){
            throw new Exception();
throw new IOException("null id");

        }
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setStudentId(null);
        scheduleEntity.setStudentName(scheduleRequest.getStudentName());
        scheduleEntity.setSubjectId(scheduleRequest.getSubjectId());
        scheduleEntity.setSubjectName(scheduleRequest.getSubjectName());
        return scheduleRepository.edit(id,scheduleEntity);

    }
    public void delete(Integer id) {
        scheduleRepository.deleteById(id);
    }*/

    }
    }
