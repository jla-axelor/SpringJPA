package com.example.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.db.Student;
import com.example.db.Teacher;
import com.example.exception.UserNotFoundException;
import com.example.service.ClassService;

@Controller
public class SpringJPAController {
	
	@Autowired
	ClassService classService;
	
	@PostMapping(path = "/login")
	public ModelAndView login(ModelMap model,@RequestParam String userName,String password) throws UserNotFoundException {
		Teacher teacher = classService.findTeacher(userName,password);
		if(teacher != null) {
			return getAllStudent(model,teacher.getId());
		}
		else {
			model.put("errorMessage", "Invalid Credentials");
			return new ModelAndView("index",model);
		}
	}
	
	@RequestMapping(path = "/newRegister")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@PostMapping(path = "/addTeacher")
	public ModelAndView addTeacher(ModelMap model,@Valid Teacher teacher) {
		classService.addOrUpdateTeacher(teacher);
		System.err.println(teacher.toString() +"\t"+ teacher.getPassword());
		model.put("Teacher", teacher);
		return new ModelAndView("dashboard",model);
	}
	
	@PostMapping("/addStudent")
	public ModelAndView addStudent(ModelMap model, @Valid Student student,@PathParam("tid") Long tid) throws UserNotFoundException {
		boolean checkStudent = classService.checkStudent(student.getRollNumber());
		if(!checkStudent) {
			model.put("studentExist", "");
		classService.addStudent(student,tid);
		System.err.println(student.toString() + "    "+tid);
		}
		else {
			model.put("studentExist", "Student is already exists with this roll number");
		}
		return getAllStudent(model, tid);
	}
	
	@PostMapping(path = "/updateStudentData")
	public ModelAndView updateStudent(ModelMap model,Student student) throws UserNotFoundException {
			classService.updateStudent(student);
			return getAllStudent(model, student.getTeacher().getId());
	}
	
	@GetMapping("getAllData")
	public ModelAndView getAllStudent(ModelMap model,@PathParam("tid") Long tid) throws UserNotFoundException{
		List<Student> list = classService.getAllStudentByTeacher(tid);
		if(!list.isEmpty()) model.put("list", list);
		Teacher teacher = classService.getTeacherById(tid);
		model.put("Teacher", teacher);
		return new ModelAndView("dashboard",model);
	}
	
	@GetMapping("fillData")
	public ModelAndView fillData(ModelMap model,@PathParam("sid") long sid) {
		Student s = classService.getStudentById(sid);
		model.put("s", s);
		return new ModelAndView("updateStudent",model);
	}
	
	@GetMapping("deleteStudent")
	public ModelAndView deleteStudent(ModelMap model, @PathParam("sid") Long sid,@PathParam("tid") Long tid) throws UserNotFoundException {
		classService.deleteStudent(sid);
		return getAllStudent(model, tid);
	}
}
