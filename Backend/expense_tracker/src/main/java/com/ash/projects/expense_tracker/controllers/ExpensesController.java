package com.ash.projects.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.projects.expense_tracker.models.Expenses;
import com.ash.projects.expense_tracker.services.ExpensesService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/expenses")
public class ExpensesController {
	
	@Autowired
	private ExpensesService expensesService;
	
	@GetMapping("/getExpense/{userId}")
	public List<Expenses> getExpenseByUser(@PathVariable int userId) {
		return expensesService.expenseByUser(userId);
		
	}
	
	@PostMapping("/addExpense/{userId}/{categoryId}")
	public ResponseEntity<Expenses> addExpenseByUser(@PathVariable int userId,@PathVariable int categoryId,@RequestBody double amount){
		Expenses expense=expensesService.addExpense(userId,categoryId,amount);
		return new ResponseEntity<Expenses>(expense, HttpStatus.OK);
		
	}
	


}
