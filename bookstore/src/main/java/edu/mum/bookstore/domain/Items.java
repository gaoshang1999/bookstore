package edu.mum.bookstore.domain;

import java.io.Serializable;

public class Items implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long quantity;

	@Override
	public String toString() {
		return id + " " + quantity + " ";
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
}
