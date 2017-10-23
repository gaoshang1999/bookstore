package edu.mum.bookstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

	@Query(value = "SELECT * FROM CART WHERE USER_ID = ?1 ", nativeQuery = true)
	public Cart importCartByTheUser(long userID);
}
