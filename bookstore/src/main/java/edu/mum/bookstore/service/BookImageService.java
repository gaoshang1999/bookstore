package edu.mum.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.bookstore.domain.BookImage;
import edu.mum.bookstore.repository.BookImageRepository;

public interface BookImageService {
	
	public List<BookImage> findBookImageList();
	public BookImage findOne(int id);
	public BookImage save(BookImage bookImage);

}
