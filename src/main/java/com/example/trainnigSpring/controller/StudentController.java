package com.example.trainnigSpring.controller;

import com.example.trainnigSpring.entity.StudentEntity;
import com.example.trainnigSpring.model.StudentRequest;
import com.example.trainnigSpring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> add(@RequestBody StudentRequest StudentRequest) {
        try {
            return ResponseEntity.ok(studentService.add(StudentRequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getall")
    public ResponseEntity<List<StudentEntity>> getAll() {
        try {
            return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //ค้นหา
    @GetMapping("/getall/{id}")
    public ResponseEntity<StudentEntity> getById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(studentService.getById(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<StudentEntity> edit(@PathVariable("id") Integer id, @RequestBody StudentRequest studentRequest) {
        try {
            return ResponseEntity.ok(studentService.edit(id, studentRequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }


}



