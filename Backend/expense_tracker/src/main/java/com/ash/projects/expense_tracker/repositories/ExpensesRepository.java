package com.ash.projects.expense_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.projects.expense_tracker.models.Expenses;
import com.ash.projects.expense_tracker.models.Users;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Integer> {
	
	List<Expenses> findByUsers(Users user);
	

}
