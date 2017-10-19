package edu.mum.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.UserService;



@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
 	@RequestMapping("/home")
	public String index(Model model) {  
 		return  "home/index";
	}
 	
 	@RequestMapping("/detail")
	public String detail(Model model) {  
 		return  "home/detail";
	}
 
}
