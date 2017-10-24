package edu.mum.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderItemList {

	List<OrderItem> orderItems;

	public OrderItemList() {
	}

	public OrderItemList(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		String orderItemList = "";

		for (OrderItem orderItem : orderItems)
			orderItemList += orderItem.toString();
		return orderItemList;
	}

	public void setOrder(Order order) {
		if (orderItems != null)
			for (int i = 0; i < orderItems.size(); i++)
				orderItems.get(i).setOrder(order);
	}

	public List<Book> getBooks() {

		List<Book> books = null;

		if (orderItems != null) {
			books = new ArrayList<>();
			for (OrderItem orderItem : orderItems)
				books.add(orderItem.getBook());
		}

		return books;
	}

	public long getTotalPrice() {

		long totalPrice = 0;

		if (orderItems != null) {
			for (OrderItem orderItem : orderItems)
				totalPrice += orderItem.getBook().getPrice();
		}

		return totalPrice;
	}

}
