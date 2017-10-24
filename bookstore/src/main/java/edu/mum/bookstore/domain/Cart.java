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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cart() {

	}

	public Cart(User user) {
		this.user = user;
	}

	public Cart(User user, List<Book> books) {
		this.user = user;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable
	private List<Book> books;

	public List<Book> addBookToCart(Book book) {
		if (books == null)
			this.books = new ArrayList<>();
		books.add(book);
		return books;
	}

	public List<Book> removeBookFromCartById(long bookId) {
		if(books !=null)
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookId) {
				books.remove(i);
			}
		}
		return books;
	}

	public List<Book> removeBookFromCartByIdList(long bookId) {
		if(books !=null)
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBookCount() {
		return books == null ? 0 : books.size();
	}

	public int getTotalCost() {
		int totalCost = 0;
		if (books != null)
			for (Book book : books)
				totalCost += book.getPrice();
		return totalCost;
	}

}
