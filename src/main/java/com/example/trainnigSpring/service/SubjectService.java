package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectResponse;
import com.example.trainnigSpring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectResponse add(SubjectRequest subjectRequest) {
        return subjectRepository.save(subjectRequest);

    }

    public List<SubjectResponse> getAll(){return subjectRepository.getAll();
    }
    public SubjectEntity getById(Integer id){
        return subjectRepository.findById(id);
    }

    public SubjectResponse edit(Integer id, SubjectRequest subjectRequest ){
       /* if(subjectRepository.findById(id).getById(id) == null){
            throw new Exception();
        }*/
        /*SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId(null);
        *//*subjectEntity.setSubjectName(subjectRequest.getSubjectName());*//*
        subjectEntity.setCredit(subjectRequest.getCredit());
        subjectEntity.setTeacherName(subjectRequest.getTeacherName());*/
        return subjectRepository.edit(id,subjectRequest);
    }
   /* public void delete(Integer id){
        subjectRepository.deleteById(id);
    }*/

}
