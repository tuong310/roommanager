package com.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.room.dto.ContractManufacture;
import com.room.dto.RoomManufacture;
import com.room.dto.StudentManufacture;
import com.room.service.ContractService;
import com.room.service.RoomService;
import com.room.service.StudentService;

@Controller
@RequestMapping(value = "student")
public class StudentController {


	@Autowired
	StudentService studentService;
	@Autowired
	RoomService roomService;
	@Autowired
	ContractService contractService;
	
	@RequestMapping(value="/listContract/{id}")
	public ModelAndView listContract(@PathVariable int id) {
		List<ContractManufacture> contractManufactures = contractService.findAllContracts(id);
		return new ModelAndView("listcontract","listcontract", contractManufactures);
	}
	@RequestMapping(value="/listStudent")
	public ModelAndView listStudent() {
		List<StudentManufacture> studentManufactures = studentService.findAllStudents();
		return new ModelAndView("liststudent","liststudent", studentManufactures);
	}
	@RequestMapping(value="/addStudent")
	public ModelAndView addRoom(@ModelAttribute("studentManufacture")StudentManufacture studentManufacture) {
		return new ModelAndView("addstudent","student", studentManufacture);
	}
	@RequestMapping(value="/addsaveStudent", method = RequestMethod.POST)
	public ModelAndView addsaveStudent(@ModelAttribute("studentManufacture") StudentManufacture studentManufacture) {
            studentService.saveStudent(studentManufacture);
		return new ModelAndView("redirect:/student/listStudent");
	}
	@RequestMapping(value="/editStudent/{id}")
	public ModelAndView editRoom(@PathVariable int id) {
		StudentManufacture studentManufacture = studentService.getStudent(id);
		return new ModelAndView("editstudent","student",studentManufacture );
	}
	@RequestMapping(value="/editStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("studentManufacture") StudentManufacture studentManufacture) {
            studentService.updateStudent(studentManufacture);
		return new ModelAndView("redirect:/student/listStudent");
	}
	@RequestMapping(value="/deleteStudent/{id}")
	public ModelAndView deleteStudent(@ModelAttribute("studentManufacture") StudentManufacture studentManufacture) {
		studentService.deleteStudent(studentManufacture);
		return new ModelAndView("redirect:/student/listStudent");
	}
	@ModelAttribute("rooms")
	List<RoomManufacture> listRoom(){
		return  roomService.findAllRooms();
	}
}
