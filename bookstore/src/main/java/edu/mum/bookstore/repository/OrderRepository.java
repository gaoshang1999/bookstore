package edu.mum.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	@Query(value = "SELECT * FROM ORDERS WHERE orderNo = ?1 ", nativeQuery = true)
	public Order importOrderByOrderNumber(String orderNumber);

	@Query(value = "SELECT * FROM ORDERS WHERE USER_ID = ?1 ", nativeQuery = true)
	public List<Order> importOrderOfUser(long userId);
}
