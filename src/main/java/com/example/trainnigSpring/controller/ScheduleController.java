package com.example.trainnigSpring.controller;

import com.example.trainnigSpring.entity.ScheduleEntity;
import com.example.trainnigSpring.model.ScheduleRequest;
import com.example.trainnigSpring.model.ScheduleResponse;
import com.example.trainnigSpring.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

   /* @PostMapping("/add")
    public ResponseEntity<ScheduleResponse> add(@RequestBody ScheduleRequest scheduleRequest) {
        try {
            return ResponseEntity.ok(scheduleService.add(ScheduleResponse));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

/*
    @GetMapping("/getall")
    public ResponseEntity<List<ScheduleEntity>> getAll() {
        try {
            return new ResponseEntity<>(scheduleService.getAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //ค้นหา
    @GetMapping("/getall/{id}")
    public ResponseEntity<ScheduleEntity> getById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(scheduleService.getById(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<ScheduleEntity> edit(@PathVariable("id") Integer id, @RequestBody ScheduleRequest scheduleRequest) {
        try {
            return ResponseEntity.ok(scheduleService.edit(id, scheduleRequest));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        scheduleService.delete(id);
    }*/
}
