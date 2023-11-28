package com.student.project.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.project.dto.StudentDto;
import com.student.project.entity.Student;
import com.student.project.exception.BusinessExceptionHandler;
import com.student.project.repository.StudentRepository;
import com.student.project.service.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepository repo;
	
	@Test
	public void testAddStudentData() throws BusinessExceptionHandler {
		
		Student student = new Student();
		
		StudentDto studentdto = new StudentDto();
		studentdto.setStudentId(1);
		studentdto.setStudentName("vignesh");
		studentdto.setCity("vijayawada");
		studentdto.setAge(23);
		
		BeanUtils.copyProperties(studentdto, student);
		
		
		
		String status ="Student Name = "+student.getStudentName()+" student ID = "+student.getStudentId()+" is entered successfully";
		
		when(repo.save(student)).thenReturn(student);
		assertEquals(status, service.addStudentData(studentdto));
		
	}
	
	
	public void testAddStudentDatawithnull() throws BusinessExceptionHandler {
		
		Student student = new Student();
		
		StudentDto studentdto = new StudentDto();
		studentdto.setStudentId(1);
		studentdto.setStudentName(null);
		studentdto.setCity("vijayawada");
		studentdto.setAge(23);
		
		BeanUtils.copyProperties(studentdto, student);
		
		
		//service.addStudentData(studentdto);
		assertThrows(BusinessExceptionHandler.class, ()->service.addStudentData(studentdto));
	}




}
