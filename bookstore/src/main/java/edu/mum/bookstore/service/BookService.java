package edu.mum.bookstore.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import edu.mum.bookstore.domain.Book;

public interface BookService {
	public List<Book> findAllBooks();
	public Book findOne(int id);
	public Book save(Book book);
	public void delete(Book book);
	public List<Book> findBooksByCategory( String name);
}
