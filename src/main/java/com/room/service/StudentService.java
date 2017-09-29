package com.room.service;

import java.io.Serializable;
import java.util.List;

import com.room.dto.StudentManufacture;

public interface StudentService {

	StudentManufacture getStudent(int id);
	void updateStudent(StudentManufacture student);
	void deleteStudent(StudentManufacture student);
	Serializable saveStudent(StudentManufacture student);
	List<StudentManufacture> findAllStudents();
	List<StudentManufacture> findAllRooms(int id);
}
