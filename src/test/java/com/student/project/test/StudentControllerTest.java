package com.student.project.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.student.project.controller.StudentController;
import com.student.project.dto.StudentDto;
import com.student.project.entity.Student;
import com.student.project.exception.BusinessExceptionHandler;
import com.student.project.service.StudentService;

@SpringBootTest
public class StudentControllerTest {
	
	@MockBean
	private StudentService service;
	
	@Autowired
	private StudentController controller;
	
	@Test
	public void addStudentData() throws BusinessExceptionHandler {
		Student student = new Student();
		
		StudentDto studentdto = new StudentDto();
		
		studentdto.setStudentId(1);
		studentdto.setStudentName("vignesh");
		studentdto.setCity("vijayawada");
		studentdto.setAge(23);
		
		String status ="Student Name = "+student.getStudentName()+" student ID = "+student.getStudentId()+" is entered successfully";

		
		when(service.addStudentData(studentdto)).thenReturn(status);
		
		assertThat(service.addStudentData(studentdto)).isEqualTo(status);
		
		
	}
}


