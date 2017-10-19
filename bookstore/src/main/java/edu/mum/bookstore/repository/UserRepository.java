package edu.mum.bookstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



import edu.mum.bookstore.domain.User;

@Repository
public interface UserRepository extends  PagingAndSortingRepository<User, Integer> 
{
	@Query(value = "SELECT * FROM user u WHERE u.username    LIKE CONCAT('%',?1,'%')  ", nativeQuery = true)
	public List<User> queryByUsername(String q);
	
	public User findByUsername(String username);
}

