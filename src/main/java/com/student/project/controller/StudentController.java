package com.student.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.project.dto.StudentDto;
import com.student.project.entity.Student;
import com.student.project.exception.BusinessExceptionHandler;
import com.student.project.exception.ControllerException;
import com.student.project.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudentData(@RequestBody StudentDto studentdto) {
		
		try {
		String data = service.addStudentData(studentdto);
		
		return new ResponseEntity<String>(data,HttpStatus.CREATED);
		
		}catch(BusinessExceptionHandler b) {
			
			ControllerException be = new ControllerException(b.getErrorCode(),b.getErrorMessage());
			return new ResponseEntity<ControllerException>(be,HttpStatus.CREATED);
			
		}
	}
	

}
