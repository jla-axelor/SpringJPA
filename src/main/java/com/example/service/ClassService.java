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
	
	public Teacher getTeacherById(Long tid) {
		return teacherRepo.findById(tid).get();
	}
	
	public void addStudent(Student student,Long tid) {
		Teacher t = teacherRepo.findById(tid).get();
		student.setTeacher(t);
		studentRepo.save(student);
	}
	
	public Student getStudentById(Long sid) {
		return studentRepo.findById(sid).get();
	}
	
	public List<Student> getAllStudentByTeacher(Long tid){
		return studentRepo.findByTeacherId(tid);
	}
	
	public boolean checkStudent(int rollNumber) {
		Student s = studentRepo.findByRollNumber(rollNumber);
		if(s != null) return true;
		else return false;
	}
	
	public void updateStudent(Student student) {
		studentRepo.save(student);
	}
	
	public Teacher findTeacher(String userName,String password) {
		return teacherRepo.findByUserNameAndPassword(userName,password);
	}
	
	public void deleteStudent(Long sid) {
		studentRepo.deleteById(sid);
	}
}
