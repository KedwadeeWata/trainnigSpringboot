package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.repository.SubjectRepository;
import com.example.trainnigSpring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectEntity add(SubjectRequest subjectRequest) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId(null);
        subjectEntity.setSubjectName(subjectRequest.getSubjectName());
        subjectEntity.setCredit(subjectRequest.getCredit());
        subjectEntity.setTeacherName(subjectRequest.getTeacherName());
        return subjectRepository.save(subjectEntity);

    }


    public List<SubjectEntity> getAll(){return subjectRepository.findAll();
    }
    public SubjectEntity getById(Integer id){
        return subjectRepository.findById(id).get();
    }

    public SubjectEntity edit(Integer id,SubjectRequest subjectRequest ) throws Exception{
        if(subjectRepository.findById(id).get() == null){
            throw new Exception();
        }
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId(null);
        subjectEntity.setSubjectName(subjectRequest.getSubjectName());
        subjectEntity.setCredit(subjectRequest.getCredit());
        subjectEntity.setTeacherName(subjectRequest.getTeacherName());
        return subjectRepository.save(subjectEntity);
    }
    public void delete(Integer id){
        subjectRepository.deleteById(id);
    }

}
