package com.ash.projects.expense_tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.projects.expense_tracker.models.Categories;
import com.ash.projects.expense_tracker.repositories.CategoriesRepository;

@Service
public class CategoriesService {
	
	@Autowired 
	private CategoriesRepository catRepo;

	public List<Categories> getCat() {
		return catRepo.findAll();
		
	}



	public void addCat(Categories cat) {
		catRepo.save(cat);
	}
	

}
