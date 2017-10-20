package edu.mum.bookstore.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
@RequestMapping({"/"})
public class IndexController {
	
	@Autowired
	private UserService userService;
	
 	@RequestMapping(value="/")
	public String index(Model model, Authentication authentication) {  
 		if(null == authentication) {
 			return  "redirect:/home";
 		}
 		
 		System.out.println(authentication.getAuthorities());
 		Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
 		for(GrantedAuthority gr: roles) {
 			if( gr.getAuthority().equals("ROLE_ADMIN")) { 		
 	 			return  "redirect:/user";
 	 		}
 		}
 		 
 		return  "redirect:/home";
 		  		
	}
 	
 	
 	@RequestMapping("/login")
	public String getLongin(Model model) {
 		User user = new User();
 		model.addAttribute("user", user);
  
 		return "user/login";
	}
 	
 	@RequestMapping(value="/login", method = RequestMethod.POST)
 	public String Longin(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
 
 	    return  "redirect:/";

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
	public String register(@Valid @ModelAttribute User user,BindingResult bindingResult, Model model) {
 		if (bindingResult.hasErrors()) {
 			return "user/register";
 		}
 			// save product here
 		userService.save(user);
  
 		return "redirect:/register?success";
	}
}
