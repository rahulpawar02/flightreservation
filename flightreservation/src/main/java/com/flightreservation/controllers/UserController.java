package com.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.flightreservation.entites.User;
import com.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//----------Registration part--------------
	@RequestMapping("/registerUser")
	public String showRegistrationPage()
	{
		
		return "registerUser";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user)
	{
		userRepository.save(user);
		return "login";
	}
     //-----------Login Part------------------	
	@RequestMapping("/login")
	public String showLoginPage()
	{
		
		return "login";
	}
	
   
	@RequestMapping(value= "/login",method=RequestMethod.POST)
	public String login(@RequestParam("email")String email, @RequestParam("password")String password,ModelMap modelMap)
	{ 
		
		User user = userRepository.findByEmail(email);
         if(user.getPassword().equals(password))
         {
        	return "findFlights"; 
        	}
         else {
          
        	 modelMap.addAttribute("msg","Invalid username or password please try again!");
         }
		
		return "login"; //if email and password not match the go to login page
	}
	
	
}
