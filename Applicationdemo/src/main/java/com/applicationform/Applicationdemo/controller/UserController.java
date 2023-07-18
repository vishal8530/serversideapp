package com.applicationform.Applicationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.applicationform.Applicationdemo.entity.User;
import com.applicationform.Applicationdemo.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/homepage")
	public String homepage() {
		
		return "home";
	}
	

	// handler method to handle list students and return mode and view
	@GetMapping("/users")
	public String listStudents(Model model) {
		model.addAttribute("users", userservice.getallusers());
		return "users";
	}
	
	
	@GetMapping("/users/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";
		
	}
	
	@PostMapping("/users")
	public String saveStudent(@ModelAttribute("users") User user) {
		userservice.createuser(user);
		return "redirect:/users";
	}
	

	@GetMapping("/users/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model, User user) {
		//System.out.println("Mil gaya");
		//System.out.println(user.getFirstname());
		model.addAttribute("user", userservice.getoneuser(id));
		//updateStudent(id,user,model);
		return "edit_user";
	}
	
	
	@PostMapping("/users/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model) {
		System.out.println("In Con " + user);
		// get student from database by id
		User existingusers = userservice.getoneuser(id);
		existingusers.setId(user.getId());
		existingusers.setFirstname(user.getFirstname());
		//System.out.println("Namae = "+user.getFirstname());
		existingusers.setState(user.getState());
		existingusers.setLastname(user.getLastname());
		existingusers.setDistrict(user.getDistrict());
		existingusers.setAbout(user.getAbout());
		
		// save updated student object
		
	
		userservice.Updateuser(existingusers,id);
		
		return "redirect:/users";		
	}
	
	@GetMapping("/users/{id}")
	public String deleteStudent(@PathVariable Long id, User user) {
		userservice.deleteuser(user.getId());
		return "redirect:/users";
	}
	
	@GetMapping("/users/{district}")
	public String searchoperation( @PathVariable String district) {
		
		
		 List<User> getalluserbycity = userservice.getalluserbycity(district);
		
		return "redirect:/users";
	}
	
	
	
	
	
	
	
	
	
}
