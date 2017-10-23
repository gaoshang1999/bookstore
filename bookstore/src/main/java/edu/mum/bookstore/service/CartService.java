package edu.mum.bookstore.service;

import edu.mum.bookstore.domain.Cart;

public interface CartService {

	public Cart openCart(long userID);

	public Cart addBookToCart(Cart newCartWithbookToAdd);

	public Cart removeBookFromCart(Cart newCartWithbookToRemove);

	public Cart createOrUpdateCart(Cart currentCart);

}
