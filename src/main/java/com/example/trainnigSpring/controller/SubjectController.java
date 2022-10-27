package com.example.trainnigSpring.controller;

import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.entity.SubjectEntity;
import com.example.trainnigSpring.model.SubjectRequest;
import com.example.trainnigSpring.model.SubjectRequest;
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

    @PostMapping("/add")
    public ResponseEntity<SubjectEntity> add(@RequestBody SubjectRequest subjectRequest) {
        try {
            return ResponseEntity.ok(subjectService.add(subjectRequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getall")
    public ResponseEntity<List<SubjectEntity>> getAll() {
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
    @PostMapping("/edit/{id}")
    public ResponseEntity<SubjectEntity> edit(@PathVariable("id") Integer id , @RequestBody SubjectRequest subjectRequest) {
        try {
            return ResponseEntity.ok(subjectService.edit(id,subjectRequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        subjectService.delete(id);
    }

}

