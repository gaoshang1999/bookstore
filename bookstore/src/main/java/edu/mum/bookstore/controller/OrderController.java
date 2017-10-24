package edu.mum.bookstore.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.domain.Order;
import edu.mum.bookstore.domain.OrderItem;
import edu.mum.bookstore.domain.OrderItemList;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.OrderItemService;
import edu.mum.bookstore.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	BookService bookService;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	SessionHelper sessionHelper;

	@RequestMapping("/order")
	public String listAllOrders(Model model, HttpSession session) {

		List<Order> orders = (List<Order>) orderService.listOrdersOfUser(sessionHelper.getLoginUser().getId());
		model.addAttribute("orders", orders);
		model.addAttribute("numberOfOrders", (orders == null) ? 0 : orders.size());

		return "order/orderslist";
	}

	@RequestMapping("/orders")
	public String listAllOrdersOfUsers(Model model, HttpSession session) {

		List<Order> orders = (List<Order>) orderService.listOrders();
		model.addAttribute("orders", orders);
		model.addAttribute("numberOfOrders", (orders == null) ? 0 : orders.size());

		return "order/allorders";
	}

	@RequestMapping("/order/neworder")
	public String makeOrder(@ModelAttribute("orderItemList") OrderItemList orderItemList, Model model,
			HttpSession session) {

		List<OrderItem> orderedItems = orderItemList.getOrderItems();
		Cart CartToUpdate = (Cart) session.getAttribute("cart");
		User user = sessionHelper.getLoginUser();
		Order order = new Order(user, orderedItems);

		orderItemList.setOrder(order);

		for (int i = 0; i < orderedItems.size(); i++) {
			Book book = orderedItems.get(i).getBook();
			book = bookService.findOne(book.getId());
			orderedItems.get(i).setBook(book);

			CartToUpdate.removeBookFromCartById(book.getId());
		}
		DateFormat dateFormatForOrderNumber = new SimpleDateFormat("yyyyMMdd");
		NumberFormat formatter = new DecimalFormat("000000");
		String orderNo = dateFormatForOrderNumber.format(new Date()) + "NBR" + formatter.format(orderService.count());
		order.setOrderNo(orderNo);

		order = orderService.makeOrder(order);

		session.setAttribute("cart", CartToUpdate);

		return "redirect:/order/" + orderNo;
	}

	@RequestMapping("/order/{orderno}")
	public String showOrderDetails(@PathVariable("orderno") String orderNo, Model model) {

		Order order = orderService.importOrderByOrderNumber(orderNo);
		OrderItemList orderItemList = null;
		List<Book> books = null;

		if (order != null)
			orderItemList = new OrderItemList(order.getOrderItems());

		if (orderItemList != null)
			books = orderItemList.getBooks();

		model.addAttribute("order", order);
		model.addAttribute("books", books);
		model.addAttribute("totalprice", orderItemList.getTotalPrice());

		if (books != null)
			model.addAttribute("NumberOfbooks", books.size());

		return "order/orderdetail";
	}

}
