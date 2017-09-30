package com.room.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.room.model.Login;

@Controller
@RequestMapping(value="")
public class LoginController {
      
	@RequestMapping(value="/",method = RequestMethod.GET)
	 public String Login(ModelMap mm){
		 mm.addAttribute("lg", new Login());
		 return "login";
	 }
	@RequestMapping(method = RequestMethod.POST)
	public String loginxyly(@ModelAttribute(value="lg") Login lg, ModelMap mm,HttpSession session){
		if(lg.getUsername().equals("tuong") && lg.getPassword().equals("123")){
			session.setAttribute("username", lg.getUsername());
			return "redirect:/room/listRoom";
		}
		else{
		mm.addAttribute("message","<font color=red>Username or PassWord is wrong!!</font>");
		return "login";
		}
	}
       @RequestMapping(value="/login",method = RequestMethod.POST)

	 public String Logout(ModelMap mm){
		
	 mm.addAttribute("lg", new Login());
		
 	return "redirect:/";
	 }
}
