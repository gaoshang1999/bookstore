package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.repository.BookRepository;
import edu.mum.bookstore.service.BookService;

@Service
@Transactional

public class BookServiceImpl implements BookService {
	@Autowired 
	private BookRepository bookRepository;
    
	@Override
	public List<Book> findAllBooks()
	{
		return (List<Book>) bookRepository.findAll();
		
	}
	
	@Override
	public Book findOne(int id){
		{
			
			return bookRepository.findOne(id);
		}
	}
	
	@Override
	public Book save(Book book)
	{
		return bookRepository.save(book);
	}
	
	@Override
	public void delete(Book book)
	{
		bookRepository.delete(book);
	}
	@Override
	public List<Book> findBooksByCategory(String name)
	{
		
		return (List<Book>) bookRepository.findBooksByCategory(name);
	}
}
