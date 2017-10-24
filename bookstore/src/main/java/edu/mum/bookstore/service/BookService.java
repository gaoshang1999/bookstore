package edu.mum.bookstore.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import edu.mum.bookstore.domain.Book;

public interface BookService {
	public List<Book> findAllBooks();
	public Book findOne(int id);
	public Book save(Book book);
	
	public List<Book> findBooksById( Integer id);
	public void delete(int id);
	//public List<Book> queryByBookTitle(String q);
	public List<Book> queryByBookTitle(String q);
}
