package edu.mum.bookstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import edu.mum.bookstore.domain.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Integer> 
{
	@Query(value = "SELECT * FROM user u WHERE u.username like '% :q %'  ", nativeQuery = true)
	public List<User> queryByUsername(String q);
}

