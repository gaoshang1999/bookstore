package edu.mum.bookstore.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.Order;
import edu.mum.bookstore.domain.OrderItem;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.OrderItemService;
import edu.mum.bookstore.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	BookService bookService;
	@Autowired
	OrderItemService orderItemService;

	@RequestMapping
	public String listAllOrders(Model model, HttpSession session) {

		model.addAttribute("orders", (List<Order>) orderService.listOrders());

		return "order/orderslist";
	}

	@RequestMapping("/neworder")
	public String makeOrder(@RequestParam long orderedBooksID[], Model model, HttpSession session) {

		List<Book> orderedBooks = bookService.getBooksById(orderedBooksID);
		User user = (User) session.getAttribute("user");

		List<OrderItem> orderItems = new ArrayList<>();

		for (Book book : orderedBooks) {
			orderItems.add(new OrderItem(book));
			//set quantity
		}

		Order order = new Order(user, orderItems);

		DateFormat dateFormatForOrderNumber = new SimpleDateFormat("yyyyMMdd");
		NumberFormat formatter = new DecimalFormat("000000");
		String orderNo = dateFormatForOrderNumber.format(new Date()) + "NBR" + formatter.format(orderService.count());
		order.setOrderNo(orderNo);
		
		order = orderService.makeOrder(order);
		
		model.addAttribute("order", order);
		
		return "redirect:/order/" + orderNo;
	}

	@RequestMapping("/{orderno}")
	public String showOrderDetails(@PathVariable("orderno") String orderNo, Model model) {

		return "order/orderdetail";
	}

}
