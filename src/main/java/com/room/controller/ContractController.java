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
import com.room.dto.StudentManufacture;
import com.room.service.ContractService;
import com.room.service.StudentService;

@Controller
@RequestMapping(value ="contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/listContract")
	public ModelAndView listContract() {
		List<ContractManufacture> contractManufactures = contractService.findAllContracts();
		return new ModelAndView("listcontract","listcontract", contractManufactures);
	}
	@RequestMapping(value="/addContract")
	public ModelAndView addContract(@ModelAttribute("contractManufacture")ContractManufacture contractManufacture) {
		return new ModelAndView("addcontract","contract",contractManufacture);
	}
	@RequestMapping(value="/addsaveContract", method = RequestMethod.POST)
	public ModelAndView addsaveStudent(@ModelAttribute("contractManufacture") ContractManufacture contractManufacture) {
		contractService.saveContract(contractManufacture);
		return new ModelAndView("redirect:/contract/listContract");
	}
	@RequestMapping(value="/editContract/{id}")
	public ModelAndView editContract(@PathVariable int id) {
		ContractManufacture contractManufacture = contractService.getContract(id);
		return new ModelAndView("editcontract","contract",contractManufacture );
	}
	@RequestMapping(value="/editContract", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("contractManufacture") ContractManufacture contractManufacture) {
		contractService.updateContract(contractManufacture);
		return new ModelAndView("redirect:/contract/listContract");
	}
	@RequestMapping(value="/deleteContract/{id}")
	public ModelAndView deleteContract(@ModelAttribute("contractManufacture") ContractManufacture contractManufacture) {
		contractService.deleteContract(contractManufacture);
		return new ModelAndView("redirect:/contract/listContract");
	}
	@ModelAttribute("students")
	List<StudentManufacture> listStudent(){
		return studentService.findAllStudents();
	}
}
