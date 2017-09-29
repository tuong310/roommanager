package com.room.dao;

import java.io.Serializable;
import java.util.List;

import com.room.model.Student;

public interface StudentDao {

	Student getStudent(int id);
	void updateStudent(Student student);
	void deleteStudent(Student student);
	Serializable saveStudent(Student student);
	List<Student> findAllStudents();
	List<Student> findAllRooms(int id);
}
