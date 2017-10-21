package edu.mum.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.bookstore.domain.Category;
import edu.mum.bookstore.domain.Category;
import edu.mum.bookstore.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
//	@RequestMapping(value= {"","/list"},method=RequestMethod.GET)
//	public String getCategoryList(Model model)
//	{
//		model.addAttribute("categoryList",categoryService.findAll());
//		return "category/list";
//		
//	}
//	
//	@RequestMapping(value= {"/addCategory"},method=RequestMethod.GET)
//	public String getForm(@ModelAttribute("category") Category category,Model model)
//	{
//		return "category/categoryForm";
//	}
//	
//	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
//	public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes ra)
//	{
//		Category category1=categoryService.save(category);
//		ra.addFlashAttribute("category",category);
//		return "redirect:/category/";
//		
//		
//	}
//	
//	
//	@RequestMapping("/edit/{id}")
//	public String getEdit(@PathVariable("id") Long id,@ModelAttribute("category") Category category, Model model) {
// 		Category cat=categoryService.findOne(id);
// 		model.addAttribute("category", cat);
//  
// 		return "category/edit";
//	}
// 	
// 	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
//	public String saveCategory(@PathVariable Long id, @ModelAttribute("category") Category category, Model model) {
// 		
// 		categoryService.save(category);
// 		   
// 		return "redirect:/category/";
//	}
// 	
//	
//	
//	@RequestMapping(value="details",method=RequestMethod.GET)
//	public String getcategoryDetails(Model model) {
//		
//		return "categoryDetails";
//	}
	
 	@RequestMapping()
	public String list(Model model) {
 		List<Category> userList = categoryService.findAll();
 		model.addAttribute("list", userList);
  
 		return "category/list";
	}
 	
 	@RequestMapping("/new")
	public String getNew(Model model) {
 		Category category = new Category();
 		model.addAttribute("category", category);
  
 		return "category/edit";
	}
 	
 	@RequestMapping("/edit/{id}")
	public String getEdit(@PathVariable Integer id, Model model) {
 		Category category = categoryService.findOne(id);
 		model.addAttribute("category", category);
  
 		return "category/edit";
	}
 	
 	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String save(@PathVariable Integer id,@Valid @ModelAttribute Category category,BindingResult result, Model model) {
 		
 		if(result.hasErrors())
 		{
 			
 			return "category/edit";
 		}
 		categoryService.save(category);
 		   
 		return "redirect:/category/";
	}
 	
 	
 	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer id) {
 		categoryService.delete(id);
 		
 		return "redirect:/category/";
	}
 	
 	
// 	@RequestMapping("/query")
//	public String query(@RequestParam String q, Model model) {
// 		List<Category> userList = categoryService.query(q);
// 		model.addAttribute("list", userList);
//  
// 		return "category/list";
//	}

}
