package edu.mum.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
	@Query("select b from Book b where b.category.name=:name")
	public List<Book> findBooksByCategory(@Param("name") String name);

}
