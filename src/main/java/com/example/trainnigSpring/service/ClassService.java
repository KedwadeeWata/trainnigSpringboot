package com.example.trainnigSpring.service;

import com.example.trainnigSpring.entity.ClassEntity;
import com.example.trainnigSpring.entity.ClassEntity;
import com.example.trainnigSpring.model.ClassRequest;
import com.example.trainnigSpring.model.ClassRequest;
import com.example.trainnigSpring.repository.ClassRepository;
import com.example.trainnigSpring.repository.ClassRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    public ClassEntity add(ClassRequest ClassRequest){
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassId(null);
        classEntity.setSecClass(ClassRequest.getSecClass());
        classEntity.setNumberStudentClass(ClassRequest.getNumberStudentClass());
        return classRepository.save(classEntity);

    }
    public List<ClassEntity> getAll(){return classRepository.findAll();
    }
    public ClassEntity getById(Integer id){
        return classRepository.findById(id).get();
    }

    public ClassEntity edit(Integer id,ClassRequest classRequest ) throws Exception{
        if(classRepository.findById(id).get() == null){
            throw new Exception();
        }
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassId(null);
        classEntity.setSecClass(classRequest.getSecClass());
        classEntity.setNumberStudentClass(classRequest.getNumberStudentClass());
        return classRepository.save(classEntity);

    }
    public void delete(Integer id){
        classRepository.deleteById(id);
    }
}

