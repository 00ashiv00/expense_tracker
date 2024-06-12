package com.ash.projects.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.projects.expense_tracker.models.Categories;
import com.ash.projects.expense_tracker.services.CategoriesService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;

	@GetMapping("/all")
	public List<Categories> getAllCategories() {
		return categoriesService.getCat();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Categories> addCategory(@RequestBody Categories cat){
		categoriesService.addCat(cat);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	

}
