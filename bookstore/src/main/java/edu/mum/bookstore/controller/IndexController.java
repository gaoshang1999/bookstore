package edu.mum.bookstore.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.bookstore.domain.Cart;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.CartService;
import edu.mum.bookstore.service.UserService;

@Controller
@RequestMapping({ "/" })
public class IndexController {

	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	SessionHelper sessionHelper;

	@RequestMapping(value = "/")
	public String index(Model model, Authentication authentication, HttpSession session) {
		if (null == authentication) {
			return "redirect:/home";
		}
		System.out.println(authentication.getAuthorities());
		Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
		for (GrantedAuthority gr : roles) {
			if (gr.getAuthority().equals("ROLE_ADMIN")) {
				return "redirect:/user";
			}
		}

		Cart cart = cartService.openCart(sessionHelper.getLoginUser().getId());
		if (cart == null) {
			cart = cartService.createOrUpdateCart(new Cart(sessionHelper.getLoginUser()));
		}
		session.setAttribute("cart", cart);
		session.setAttribute("bookCartCount", cart.getBookCount());
		return "redirect:/home";

	}

	@RequestMapping("/login")
	public String getLongin(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Longin(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(auth);

		return "redirect:/";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}

	@RequestMapping("/register")
	public String getRegister(@ModelAttribute User user, Model model) {
		return "user/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model,
			HttpSession session) {
		User u = userService.findByUsername(user.getUsername());
		if(null != u) {
			bindingResult.addError(new ObjectError("username", "username is occupied, please use a new one."));
		}
		
		if (bindingResult.hasErrors()) {
			return "user/register";
		}
		// save product here
		
		
// 		userService.save(user);		
		user.encodeMyPassword();

		Cart cart = cartService.createOrUpdateCart(new Cart(user));
		session.setAttribute("cart", cart );

		return "redirect:/register?success";
	}
}
