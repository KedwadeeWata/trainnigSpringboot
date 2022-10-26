package com.example.trainnigSpring.repository;


import com.example.trainnigSpring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository ดึงมาใช้ ใน class StudentEntity
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

}
