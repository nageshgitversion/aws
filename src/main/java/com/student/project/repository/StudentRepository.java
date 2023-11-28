package com.student.project.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.project.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable>{

}
