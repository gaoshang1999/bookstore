package edu.mum.bookstore.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.Password;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.CategoryService;
import edu.mum.bookstore.service.UserService;



@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;
	
	@Autowired
	SessionHelper sessionHelper;
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String index(Model model) {  
		
		List<Book> books = bookService.findAllBooks();
		Collections.shuffle(books);
		List<Book> subList = books.subList(0, books.size()>6 ? 6: books.size() );
 		
 		model.addAttribute("categoryList", categoryService.findAll());
 		model.addAttribute("bookList", subList);
 	 	
 		return   "home/index";
	}
	
	
 	@RequestMapping(value="/home/{category}",method=RequestMethod.GET)
	public String indexByCategory(@PathVariable("category") String category,Model model) {  
 		
 		model.addAttribute("categoryList", categoryService.findAll());
 		model.addAttribute("bookList",bookService.findBooksByCategory(category));
 	 	
 		return   "home/index";
	}
 	
 	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id,Model model) { 
 		model.addAttribute("categoryList", categoryService.findAll());
 		model.addAttribute("book",bookService.findOne(id));
 		return  "home/detail";
	}
 	
 	@RequestMapping("/profile")
	public String profile(Model model) {  
 		User user = sessionHelper.getLoginUser();
 		model.addAttribute("user", user);
 		return  "profile/profile";
	}
 	
 	@RequestMapping("/profile/edit")
	public String getprofile(Model model) {  
 		User user = sessionHelper.getLoginUser();
 		model.addAttribute("user", user);
 		return  "profile/edit";
	}
 	
 	@RequestMapping(value ="/profile/edit", method = RequestMethod.POST)
	public String saveprofile(@Valid @ModelAttribute User user,BindingResult bindingResult, Model model) {  
 		if (bindingResult.hasErrors()) {
 			return  "profile/edit";
 		}
 		userService.save(user);
 		sessionHelper.reloadLoginUser();
 		
 		return "redirect:/profile";
	}
 	
 	@RequestMapping("/profile/changePassword")
	public String getChangepassword(@ModelAttribute Password password, Model model) {  
 	 	return  "profile/change_password";
	}
 	
 	@RequestMapping(value ="/profile/changePassword", method = RequestMethod.POST)
	public String saveChangepassword(@Valid @ModelAttribute Password password, BindingResult bindingResult) {  
 		
 		String old = password.getOld_password() ;
 		User user = sessionHelper.getLoginUser();
 		if(!passwordEncoder.matches(old, user.getPassword()) ) {
 			bindingResult.addError(new ObjectError("old_password", "old password is not correct"));
 		}
 		if(!password.isMath()) {
 			bindingResult.addError(new ObjectError("confirm_password", "confirm password does not match new password"));
 		}
 		if (bindingResult.hasErrors()) {
 			return  "profile/change_password";
 		}
 		
 		user.setPassword(password.getNew_password());
 		userService.save(user);
 		sessionHelper.reloadLoginUser();
 		
 		return  "redirect:/profile/changePassword?sucess";
	}
 	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
 
}
