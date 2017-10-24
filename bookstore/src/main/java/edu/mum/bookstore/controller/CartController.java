package edu.mum.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.domain.OrderItemList;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	BookService bookService;
	@Autowired
	SessionHelper sessionHelper;

	@RequestMapping()
	public String showCart(Model model, HttpSession session) {

		long userID = sessionHelper.getLoginUser().getId();

		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = cartService.openCart(userID);
		if (cart == null)
			cart = new Cart(sessionHelper.getLoginUser());

		model.addAttribute("books", cart.getBooks());
		session.setAttribute("bookCartCount", cart.getBookCount());
		session.setAttribute("bookCartTotalCost", cart.getTotalCost());

		model.addAttribute("orderItemList", new OrderItemList());

		return "cart/cart";
	}

	@RequestMapping(value = "/add/{bookID}")
	public @ResponseBody Cart addBookToCart(@PathVariable("bookID") int bookID, Model model, HttpSession session) {

		Cart CartToUpdate = (Cart) session.getAttribute("cart");
		if (CartToUpdate == null) {
			CartToUpdate = cartService.createOrUpdateCart(new Cart(sessionHelper.getLoginUser()));
		}
		CartToUpdate.addBookToCart(bookService.findOne(bookID));
		session.setAttribute("cart", CartToUpdate);
		session.setAttribute("bookCartCount", CartToUpdate.getBookCount());
		session.setAttribute("bookCartTotalCost", CartToUpdate.getTotalCost());

		return CartToUpdate;
	}

	@RequestMapping("/remove/{bookID}")
	public @ResponseBody Cart removeBookFromCart(@PathVariable long bookID, Model model, HttpSession session) {
		
		Cart CartToUpdate = (Cart) session.getAttribute("cart");
		if (CartToUpdate == null) {
			CartToUpdate = cartService.createOrUpdateCart(new Cart(sessionHelper.getLoginUser()));
		}
		CartToUpdate.removeBookFromCartById(bookID);
		session.setAttribute("cart", CartToUpdate);
		session.setAttribute("bookCartCount", CartToUpdate.getBookCount());
		session.setAttribute("bookCartTotalCost", CartToUpdate.getTotalCost());

		return CartToUpdate;
	}

}
