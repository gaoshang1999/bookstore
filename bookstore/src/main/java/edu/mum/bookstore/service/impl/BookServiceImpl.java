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
	public List<Book> findBooksById( Integer id)
	{
		
		return (List<Book>) bookRepository.findBooksById(id);
	}
	@Override
	public void delete(int id)
	{
		
		 bookRepository.delete(id);
	}
	@Override
	public List<Book> queryByBookTitle(String q)
	{
		return (List<Book>) bookRepository.queryByBookTitle(q);
		
	}
}
