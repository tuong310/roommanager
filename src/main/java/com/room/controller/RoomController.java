package com.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.room.dto.RoomManufacture;
import com.room.dto.StudentManufacture;
import com.room.service.RoomService;
import com.room.service.StudentService;

@Controller
@RequestMapping(value = "room")
public class RoomController {

	@Autowired
	RoomService roomService;
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/listStudent/{id}")
	public ModelAndView listStudentId(@PathVariable int id) {
		List<StudentManufacture> studentManufactures = studentService.findAllRooms(id);
		return new ModelAndView("liststudent","liststudent", studentManufactures);
	}
	@RequestMapping(value="/listRoom")
	public ModelAndView listRoom() {
          List<RoomManufacture> roomManufactures = roomService.findAllRooms();
		return new ModelAndView("listroom","listroom", roomManufactures);
	}
	@RequestMapping(value="/addRoom")
	public ModelAndView addRoom(@ModelAttribute("roomManufacture") RoomManufacture roomManufacture) {
		return new ModelAndView("addroom","room", roomManufacture);
	}
	@RequestMapping(value="/addsaveRoom", method = RequestMethod.POST)
	public ModelAndView addsaveRoom(@ModelAttribute("roomManufacture") RoomManufacture roomManufacture) {
            roomService.saveRoom(roomManufacture);
		return new ModelAndView("redirect:/room/listRoom");
	}
	@RequestMapping(value="/editRoom/{id}")
	public ModelAndView editRoom(@PathVariable int id) {
           RoomManufacture roomManufacture = roomService.getRoom(id);
		return new ModelAndView("editroom", "room", roomManufacture);
	}
	@RequestMapping(value="/editRoom", method = RequestMethod.POST)
	public ModelAndView saveRoom(@ModelAttribute("roomManufacture") RoomManufacture roomManufacture) {
            roomService.updateRoom(roomManufacture);
		return new ModelAndView("redirect:/room/listRoom");
	}
	@RequestMapping(value="/deleteRoom/{id}")
	public ModelAndView deleteRoom(@ModelAttribute("roomManufacture") RoomManufacture roomManufacture) {
		 roomService.deleteRoom(roomManufacture);
		 
		return new ModelAndView("redirect:/room/listRoom");
	}
}
