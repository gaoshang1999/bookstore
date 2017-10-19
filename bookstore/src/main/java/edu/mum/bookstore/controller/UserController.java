package edu.mum.bookstore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	SessionHelper sessionHelper;
	
 	@RequestMapping()
	public String list(Model model) {
 		List<User> userList = userService.getAll();
 		model.addAttribute("list", userList);
 		System.out.println(sessionHelper.getLoginUser());
 		return "user/list";
	}
 	
 	@RequestMapping("/new")
	public String getNew(Model model) {
 		User user = new User();
 		model.addAttribute("user", user);
 		
 		return "user/edit";
	}
 	
 	@RequestMapping("/edit/{id}")
	public String getEdit(@PathVariable Integer id, Model model) {
 		User user = userService.findOne(id);
 		model.addAttribute("user", user);
  
 		return "user/edit";
	}
 	
 	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String save(@PathVariable Integer id, @ModelAttribute User user, Model model) {
 		
 		userService.save(user);
 		   
 		return "redirect:/user/";
	}
 	
 	
 	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer id) {
 		userService.delete(id);
 		
 		return "redirect:/user/";
	}
 	
 	
 	@RequestMapping("/query")
	public String query(@RequestParam String q, Model model) {
 		List<User> userList = userService.query(q);
 		model.addAttribute("list", userList);
  
 		return "user/list";
	}
}
