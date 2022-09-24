package com.example.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.db.Teacher;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
	public Teacher findByUserNameAndPassword(String userName,String password);
	public Teacher findByUserNameAndAge(String userName,int age);
}
