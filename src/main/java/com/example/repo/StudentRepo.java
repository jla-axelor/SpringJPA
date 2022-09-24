package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.db.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	public List<Student> findByTeacherId(Long tid);
	public Student findByRollNumber(int rollNumber);
}
