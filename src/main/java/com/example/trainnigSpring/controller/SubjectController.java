package com.example.trainnigSpring.controller;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectResponse;
import com.example.trainnigSpring.repository.SubjectRepository;
import com.example.trainnigSpring.service.SubjectService;
import com.example.trainnigSpring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/add")
    public SubjectResponse add(@RequestBody SubjectRequest subjectRequest) {
        return subjectRepository.save(subjectRequest);
    }

    @PostMapping("/edit/{id}")
    public SubjectResponse edit(@PathVariable("id") Integer id , @RequestBody SubjectRequest subjectRequest) {
        return subjectRepository.edit(id, subjectRequest);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<SubjectResponse>> getAll() {
        try {
            return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



    //ค้นหา
    @GetMapping("/getid/{id}")
    public ResponseEntity<SubjectEntity> getById(@PathVariable("id") Integer id)
    {
        try {
            return ResponseEntity.ok(subjectService.getById(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

/*
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        subjectService.delete(id);
    }*/

}

