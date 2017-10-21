package edu.mum.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.BookImage;
@Repository

public interface BookImageRepository extends CrudRepository<BookImage,Integer>{

	
	

}
