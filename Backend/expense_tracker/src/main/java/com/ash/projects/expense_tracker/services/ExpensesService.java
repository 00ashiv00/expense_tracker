package com.ash.projects.expense_tracker.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.projects.expense_tracker.models.Categories;
import com.ash.projects.expense_tracker.models.Expenses;
import com.ash.projects.expense_tracker.models.Users;
import com.ash.projects.expense_tracker.repositories.CategoriesRepository;
import com.ash.projects.expense_tracker.repositories.ExpensesRepository;
import com.ash.projects.expense_tracker.repositories.UsersRepository;

@Service
public class ExpensesService {
	
	private ExpensesRepository expensesRepo;
	private UsersRepository usersRepo;
	private CategoriesRepository categoriesRepo;
	
	

	@Autowired
	public ExpensesService(ExpensesRepository expensesRepo,UsersRepository usersRepo,CategoriesRepository categoriesRepo) {
		this.expensesRepo=expensesRepo;
		this.usersRepo=usersRepo;
		this.categoriesRepo=categoriesRepo;
	}

	public List<Expenses> expenseByUser(int userId) {
		Users user=usersRepo.findById(userId).get();
		return expensesRepo.findByUsers(user);
		
	}

	public void addExpense(Expenses expense) {
		expensesRepo.save(expense);
		
	}

	public Expenses addExpense(int userId, int categoryId, double amount) {
		Users user=usersRepo.findById(userId).get();
		Categories category= categoriesRepo.findById(categoryId).get();
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date=now.format(formatter);
		Expenses expense=new Expenses(1,amount,date,category,user);
		expensesRepo.save(expense);
		return expense;
		
		
		
	}

}
