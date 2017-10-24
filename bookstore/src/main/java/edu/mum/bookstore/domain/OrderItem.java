package edu.mum.bookstore.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderItem() {

	}

	public OrderItem(Book book) {
		this.book = book;
	}

	public OrderItem(Order order, Book book) {
		this.order = order;
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long quantity;


	@ManyToOne(fetch = FetchType.EAGER)
	private Order order;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Book book;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return book.getId() + " " + quantity;
	}
}
