package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.Student;
import com.example.db.Teacher;
import com.example.service.ClassService;

@RestController
@RequestMapping(path = "class")
public class SpringJPAController {
	
	@Autowired
	ClassService classService;
	
	@PostMapping("/teacher")
	public void addTeacher(@RequestBody Teacher teacher) {
		classService.addOrUpdateTeacher(teacher);
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody Student student) {
		classService.addStudent(student);
	}
	
	@GetMapping("/students")
	public void getAllStudent() {
		classService.getAllStudent();
	}
}
