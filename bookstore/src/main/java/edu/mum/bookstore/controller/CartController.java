package edu.mum.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	BookService bookService;

	@RequestMapping()
	public String showCart(Model model, HttpSession session) {
		long id = ((User) session.getAttribute("user")).getId();
		model.addAttribute("books", cartService.openCart(id));
		return "cart/cart";
	}

	@RequestMapping("/add/{bookID}")
	public @ResponseBody Cart addBookToCart(@PathVariable long bookID, Model model, HttpSession session) {

		Cart CartToUpdate = (Cart) model.asMap().get("cart");
		CartToUpdate.addBookToCart(bookService.getBookById(bookID));
		session.setAttribute("cart", CartToUpdate);
		// model.addAttribute("cart", CartToUpdate);

		return CartToUpdate;
	}

	@RequestMapping("/remove/{bookID}")
	public @ResponseBody Cart removeBookFromCart(@PathVariable long bookID, Model model, HttpSession session) {

		Cart CartToUpdate = (Cart) model.asMap().get("cart");
		CartToUpdate.removeBookFromCartById(bookID);
		session.setAttribute("cart", CartToUpdate);
		model.addAttribute("cart", CartToUpdate);

		return CartToUpdate;
	}

}
