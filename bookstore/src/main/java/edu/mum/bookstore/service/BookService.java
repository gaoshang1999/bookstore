package edu.mum.bookstore.service;

import java.util.List;

import edu.mum.bookstore.domain.Book;

public interface BookService {

	public Book getBookById(long bookID);

	public List<Book> getBooksById(long bookID[]);

}
