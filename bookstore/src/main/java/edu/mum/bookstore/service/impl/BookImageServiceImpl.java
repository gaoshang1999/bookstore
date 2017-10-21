package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.BookImage;
import edu.mum.bookstore.repository.BookImageRepository;
import edu.mum.bookstore.service.BookImageService;

@Service
@Transactional

public class BookImageServiceImpl implements BookImageService {
	@Autowired 
	private BookImageRepository bookImageRepository;
	
	public List<BookImage> findBookImageList()
	{
		return (List<BookImage>) bookImageRepository.findAll();
		
	}
	public BookImage findOne(int id)
	{
		
		return  bookImageRepository.findOne(id);
	}
	
	public BookImage save(BookImage bookImage)
	{
		
		return bookImageRepository.save(bookImage);
	}

}
