package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;

import java.util.List;

public interface SubjectServiceln {
    SubjectEntity add(SubjectRequest subjectRequest);
    List<SubjectEntity> getAll();
    SubjectEntity getById(Integer id);
    SubjectEntity edit(Integer id,SubjectRequest subjectRequest ) throws Exception;
    void delete(Integer id);


}
