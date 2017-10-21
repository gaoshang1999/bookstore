package edu.mum.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.repository.CartRepository;
import edu.mum.bookstore.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	public Cart openCart(long userID) {
		return cartRepository.importCartByTheUser(userID);
	}

	public Cart addBookToCart(Cart newCartWithbookToAdd) {
		return cartRepository.save(newCartWithbookToAdd);
	}

	public Cart removeBookFromCart(Cart newCartWithbookToRemove) {
		return cartRepository.save(newCartWithbookToRemove);
	}

	public Cart createOrUpdateCart(Cart currentCart) {
		return cartRepository.save(currentCart);
	}

}
