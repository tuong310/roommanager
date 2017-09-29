package com.room.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.room.dao.RoomDao;
import com.room.dao.StudentDao;
import com.room.dto.StudentManufacture;
import com.room.model.Room;
import com.room.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	RoomDao roomDao;
	public Student convert(StudentManufacture studentManufacture){
            
		Student student = new Student();
		student.setId(studentManufacture.getId());
		student.setName(studentManufacture.getName());
		student.setContract(studentManufacture.getContract());
		student.setGender(studentManufacture.getGender());
		student.setAddress(studentManufacture.getAddress());
		student.setPhone(studentManufacture.getPhone());
		return student;
		
	}
	public StudentManufacture convert(Student student){
		StudentManufacture studentManufacture = new StudentManufacture();
		if(student.getRoom() !=null){
			studentManufacture.setRoomId(student.getRoom().getId());
		}
		studentManufacture.setId(student.getId());
		studentManufacture.setName(student.getName());
		studentManufacture.setContract(student.getContract());
		studentManufacture.setAddress(student.getAddress());
		studentManufacture.setGender(student.getGender());
		studentManufacture.setPhone(student.getPhone());
		return studentManufacture;
	}
	@Override
	public StudentManufacture getStudent(int id) {
	      Student student = studentDao.getStudent(id);
	      StudentManufacture studentManufacture = convert(student);
		return studentManufacture;
	}

	@Override
	public void updateStudent(StudentManufacture studentManufacture) {
		Room room = roomDao.getRoom(studentManufacture.getRoomId());
		Student student = convert(studentManufacture);
		student.setRoom(room);
		studentDao.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(StudentManufacture studentManufacture) {
		Room room = roomDao.getRoom(studentManufacture.getRoomId());
		Student student = convert(studentManufacture);
		student.setRoom(room);
		studentDao.deleteStudent(student);

	} 

	@Override
	public Serializable saveStudent(StudentManufacture studentManufacture) {
		Room room = roomDao.getRoom(studentManufacture.getRoomId());
		Student student = convert(studentManufacture);
		student.setRoom(room);
		return studentDao.saveStudent(student);
	}

	@Override
	public List<StudentManufacture> findAllStudents() {
		List<StudentManufacture> studentManufactures = new ArrayList<StudentManufacture>();
		List<Student> students = studentDao.findAllStudents();
		if(!CollectionUtils.isEmpty(students)){
			for(Student student : students){
				studentManufactures.add(convert(student));}}
		return studentManufactures;
	}
	@Override
	public List<StudentManufacture> findAllRooms(int id) {
		List<StudentManufacture> studentManufactures = new ArrayList<StudentManufacture>();
		List<Student> students = studentDao.findAllRooms(id);
		if(!CollectionUtils.isEmpty(students)){
			for(Student student : students){
				studentManufactures.add(convert(student));}}
		return studentManufactures;
	}
}
