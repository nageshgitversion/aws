package com.student.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.project.dto.StudentDto;
import com.student.project.entity.Student;
import com.student.project.exception.BusinessExceptionHandler;
import com.student.project.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	
	
	public String addStudentData(StudentDto studentdto) throws BusinessExceptionHandler{
		Student student = new Student();
		BeanUtils.copyProperties(studentdto, student);
		try {
		if(student.getStudentName().isEmpty()|| student.getStudentName().length() ==0)
			throw new BusinessExceptionHandler("601","kindly provide proper Name");
		
		repo.save(student);
		
		
		}catch(NullPointerException n){
			throw new BusinessExceptionHandler("602","null value is entered in the name field "+n.getMessage());
		}catch(Exception e) {
			throw new BusinessExceptionHandler("603","Name field is empty "+e.getMessage());
		}
		
		return "Student Name = "+student.getStudentName()+" student ID = "+student.getStudentId()+" is entered successfully";
	}
	
	
	
	

}
