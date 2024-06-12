package com.ash.projects.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.projects.expense_tracker.models.Users;
import com.ash.projects.expense_tracker.services.UsersService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return usersService.allUsers();
		
	}

}
