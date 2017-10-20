package edu.mum.bookstore.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.bookstore.domain.Password;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.UserService;



@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	SessionHelper sessionHelper;
	
 	@RequestMapping("/home")
	public String index(Model model) {  
 		return  "home/index";
	}
 	
 	@RequestMapping("/detail")
	public String detail(Model model) {  
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
