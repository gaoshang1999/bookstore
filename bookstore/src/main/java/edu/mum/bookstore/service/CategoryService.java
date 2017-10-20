package edu.mum.bookstore.service;

import java.util.List;

import edu.mum.bookstore.domain.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category findOne(Integer id);
	public Category save(Category category);
	public void delete(Integer category);

}
