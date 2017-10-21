package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.OrderItem;
import edu.mum.bookstore.repository.OrderItemRepository;
import edu.mum.bookstore.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public OrderItem addBooksToOrder(OrderItem OrderItemWithNewBook) {
		return orderItemRepository.save(OrderItemWithNewBook);
	}

}
