package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.db.Student;
import com.example.db.Teacher;
import com.example.repo.StudentRepo;
import com.example.repo.TeacherRepo;

@Service
public class ClassService {
	
	@Autowired
	TeacherRepo teacherRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	public void addOrUpdateTeacher(Teacher teacher) {
		teacherRepo.save(teacher);
	}
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public Student getStudentById(Long sid) {
		return studentRepo.findById(sid).get();
	}
	
	public List<Student> getAllStudent(){
		return (List<Student>)studentRepo.findAll();
	}
}
