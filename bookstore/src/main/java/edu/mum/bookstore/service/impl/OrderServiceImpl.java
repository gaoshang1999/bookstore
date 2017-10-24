package edu.mum.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.Order;
import edu.mum.bookstore.repository.OrderRepository;
import edu.mum.bookstore.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order makeOrder(Order order) {
		return orderRepository.save(order);
	}

	public List<Order> listOrders() {
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

}
