package edu.mum.bookstore.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@SessionAttributes("order")
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
			HttpSession session, RedirectAttributes redirectAttribute) {

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
		session.setAttribute("bookCartCount", CartToUpdate.getBookCount());
		model.addAttribute("order", order);

		return "forward:/order/shippingdata";
	}

	@RequestMapping("/order/shippingdata")
	public String insertShippingData(@ModelAttribute("order") Order order, Model model) {

		model.addAttribute("order", (Order) model.asMap().get("order"));

		return "cart/shippingdata";
	}

	@RequestMapping(value = "/order/{orderno}", method = RequestMethod.POST)
	public String getShippingData(@ModelAttribute("order") @Valid Order order, BindingResult bindingResult,
			@PathVariable("orderno") String orderNo, Model model) {

		if (bindingResult.hasErrors()) {
			return "cart/shippingdata";
		}
		System.out.println("here");
		Order oldOrder = orderService.importOrderByOrderNumber(orderNo);
		System.out.println(order.getAddress());
		order = oldOrder.updateShippingDataOrder(order);
		orderService.makeOrder(order);

		return "redirect:/order/" + orderNo;
	}

	@RequestMapping(value = "/order/{orderno}")
	public String showOrderDetails(@PathVariable("orderno") String orderNo, Model model) {

		Order order = orderService.importOrderByOrderNumber(orderNo);
		OrderItemList orderItemList = null;

		model.addAttribute("order", order);

		if (order != null) {
			orderItemList = new OrderItemList(order.getOrderItems());
			model.addAttribute("orderitemlist", order.getOrderItems());
		}
		if (orderItemList != null)
			model.addAttribute("totalprice", orderItemList.getTotalPrice());

		return "order/orderdetail";
	}

}
