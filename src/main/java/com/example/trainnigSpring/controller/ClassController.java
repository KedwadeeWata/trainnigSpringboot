package com.example.trainnigSpring.controller;

import com.example.trainnigSpring.entity.ClassEntity;
import com.example.trainnigSpring.model.ClassRequest;
import com.example.trainnigSpring.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @PostMapping("/add")
    public ClassEntity add(@RequestBody ClassRequest classRequest) {
        return classService.add(classRequest);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ClassEntity>> getAll() {
        try {
            return new ResponseEntity<>(classService.getAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //ค้นหา
    @GetMapping("/getid/{id}")
    public ResponseEntity<ClassEntity> getById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(classService.getById(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<ClassEntity> edit(@PathVariable("id") Integer id, @RequestBody ClassRequest classrequest) {
        try {
            return ResponseEntity.ok(classService.edit(id, classrequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        classService.delete(id);
    }


}
