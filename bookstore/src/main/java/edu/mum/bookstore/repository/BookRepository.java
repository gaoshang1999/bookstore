package edu.mum.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
	@Query("select b from Book b where b.category.id=:id")
	public List<Book> findBooksById(@Param("id") Integer id);
	@Query(value = "SELECT * FROM Book b WHERE b.title    LIKE CONCAT('%',?1,'%')  ", nativeQuery = true)
	public List<Book> queryByBookTitle(String q);
	
	@Query("select b from Book b where b.title=:title")
	public Book findBookByTitle(@Param("title") String title);
	
}
