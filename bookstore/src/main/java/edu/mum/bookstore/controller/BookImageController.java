package edu.mum.bookstore.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.bookstore.domain.BookImage;
import edu.mum.bookstore.service.BookImageService;

@RequestMapping("/bookImage")
public class BookImageController {
	@Autowired
	private BookImageService bookImageService;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getList( Model model)
	{
		model.addAttribute("imageList",bookImageService.findBookImageList());
		return "bookImage/list";
	}
	
    
	@RequestMapping(value="/addImage",method=RequestMethod.GET)
	public String getForm(@ModelAttribute("bookImage") BookImage bookImage, Model model)
	{
		return "bookImage/imageForm";
	}
	
	@RequestMapping(value="/addImage",method=RequestMethod.POST)
	public String addImage(@ModelAttribute("bookImage") BookImage bookImage)
	{
		bookImageService.save(bookImage);
		
		MultipartFile bookImage1 = bookImage.getBookImage();
		System.out.println("Book Title:");
		

		String rootDirectory = servletContext.getRealPath("/");

		
		if (bookImage1 != null && !bookImage1.isEmpty()) {
			try {
				String imagePath = rootDirectory + "\\resources\\images\\" + bookImage.getId() + ".png";
				bookImage1.transferTo(new File(imagePath));
				bookImage.setImagePath(imagePath);
			} catch (Exception e) {
				throw new RuntimeException("Failed to save employee image.", e);
			}
		}
		
		
		return "redirect:/bookImage/list";
	}
}
