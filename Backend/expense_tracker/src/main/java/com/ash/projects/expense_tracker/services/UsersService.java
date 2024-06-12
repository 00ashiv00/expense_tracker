package com.ash.projects.expense_tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.projects.expense_tracker.models.Users;
import com.ash.projects.expense_tracker.repositories.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;

	public List<Users> allUsers() {
		return usersRepo.findAll();
	}

}
