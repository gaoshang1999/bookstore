package edu.mum.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cart() {

	}

	public Cart(User user, List<Book> books) {
		this.user = user;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable
	private List<Book> books;

	public List<Book> addBookToCart(Book book) {
		if (books == null)
			this.books = new ArrayList<>();
		books.add(book);
		return books;
	}

	public List<Book> removeBookFromCartById(long bookId) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookId) {
				books.remove(i);
			}
		}
		return books;
	}

	public User getUser() {
		return user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBook() {
		return books;
	}

	public void setBook(List<Book> book) {
		this.books = book;
	}

}
