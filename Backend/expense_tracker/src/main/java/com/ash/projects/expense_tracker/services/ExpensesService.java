package com.ash.projects.expense_tracker.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.projects.expense_tracker.models.Categories;
import com.ash.projects.expense_tracker.models.Expenses;
import com.ash.projects.expense_tracker.repositories.CategoriesRepository;
import com.ash.projects.expense_tracker.repositories.ExpensesRepository;

@Service
public class ExpensesService {
	
	private ExpensesRepository expensesRepo;
	private CategoriesRepository categoriesRepo;
	

	@Autowired
	public ExpensesService(ExpensesRepository expensesRepo,CategoriesRepository categoriesRepo) {
		this.expensesRepo=expensesRepo;
		this.categoriesRepo=categoriesRepo;
	}


	public void addExpense(Expenses expense) {
		expensesRepo.save(expense);
		
	}

	public Expenses addExpense(String name,int categoryId, double amount) {
		Categories category= categoriesRepo.findById(categoryId).get();
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
		String date=now.format(dateFormatter);
		String time=now.format(timeFormatter);
		Expenses expense=new Expenses((int)expensesRepo.count()+1,name,amount,date,time,category);
		expensesRepo.save(expense);
		return expense;
	}

	
	public List<Expenses> allExpenses() {
		return expensesRepo.findAll();
	}

}
