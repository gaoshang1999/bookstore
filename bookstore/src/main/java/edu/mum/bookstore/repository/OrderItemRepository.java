package edu.mum.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.bookstore.domain.OrderItem;


@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
