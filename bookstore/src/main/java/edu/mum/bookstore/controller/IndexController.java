package edu.mum.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/"})
public class IndexController {

	
 	@RequestMapping(value="/")
	public String listEmployees(Model model) {
  
 		return  "redirect:/user";
	}
}
