package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.Category;
import edu.mum.bookstore.repository.CategoryRepository;
import edu.mum.bookstore.service.CategoryService;

@Service
@Transactional

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll()
	{
		return (List<Category>) categoryRepository.findAll();
	}
	
	@Override
	public Category findOne(Integer id) {
		return categoryRepository.findOne(id);
	}
	
	@Override
	public Category save(Category category)
	{
		
		return categoryRepository.save(category);
	}
	
	@Override
	public void delete(Integer category)
	{
		categoryRepository.delete(category);
		
	}


}
