package com.ash.projects.expense_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.projects.expense_tracker.models.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer>{

}
