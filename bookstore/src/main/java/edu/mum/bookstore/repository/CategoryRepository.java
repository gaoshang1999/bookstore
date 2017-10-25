package edu.mum.bookstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	@Query("select c from Category c where c.name=:name")
	public Category findCategoryByName(@Param("name")String name);

}
