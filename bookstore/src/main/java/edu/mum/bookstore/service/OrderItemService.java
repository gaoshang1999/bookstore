package edu.mum.bookstore.service;

import edu.mum.bookstore.domain.OrderItem;

public interface OrderItemService {

	public OrderItem addBooksToOrder(OrderItem OrderItemWithNewBook);

	//public OrderItem createOrderItem(List<Book> orderedBooks);
}
