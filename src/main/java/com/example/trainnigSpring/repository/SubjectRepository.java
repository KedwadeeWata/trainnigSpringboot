package com.example.trainnigSpring.repository;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public SubjectResponse save(SubjectRequest subjectRequest) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(subjectRequest.getSubjectName());
        subjectEntity.setCredit(subjectRequest.getCredit());
        subjectEntity.setTeacherName(subjectRequest.getTeacherName());
        entityManager.persist(subjectEntity);

        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setSubjectName(subjectRequest.getSubjectName());
        subjectResponse.setCredit(subjectRequest.getCredit());
        subjectResponse.setTeacherName(subjectRequest.getTeacherName());
        return subjectResponse;
    }

    @Transactional
    public SubjectResponse edit(Integer id, SubjectRequest subjectRequest){
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId(id);
        subjectEntity.setSubjectName(subjectRequest.getSubjectName());
        subjectEntity.setCredit(subjectRequest.getCredit());
        subjectEntity.setTeacherName(subjectRequest.getTeacherName());
        entityManager.merge(subjectEntity);

        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setSubjectName(subjectRequest.getSubjectName());
        subjectResponse.setCredit(subjectRequest.getCredit());
        subjectResponse.setTeacherName(subjectRequest.getTeacherName());

        return subjectResponse;
    }

    public SubjectEntity findById(Integer id){
       SubjectEntity subjectEntity = (SubjectEntity) entityManager.find(SubjectEntity.class,id);
       return subjectEntity;
   }

   public List<SubjectResponse> getAll(){
       Query query = entityManager.createQuery("SELECT t FROM SubjectRequest",SubjectEntity.class);
       List<SubjectEntity> subjectEntities = query.getResultList();

        List<SubjectResponse> subjectResponse = new ArrayList<SubjectResponse>();

        subjectEntities.forEach((q)->{
            SubjectResponse subjectResponse1 = new SubjectResponse();
                subjectResponse1.setSubjectName(q.getSubjectName());
                subjectResponse1.setCredit(q.getCredit());
               subjectResponse1.setTeacherName(q.getTeacherName());
               subjectResponse.add(subjectResponse1);
       });
       return subjectResponse;
    }
}


