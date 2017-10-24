package edu.mum.bookstore.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.bookstore.domain.Book;
import edu.mum.bookstore.domain.Category;
import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.BookService;
import edu.mum.bookstore.service.CategoryService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping()
	public String getBookList(Model model) {
		model.addAttribute("bookList", bookService.findAllBooks());
		return "book/list";

	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String getForm(Model model) {
		Book book = new Book();
		
		model.addAttribute("categoryList", categoryService.findAll());
		model.addAttribute("book", book);

		return "book/edit";
	}

	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String save(@PathVariable Integer id,@Valid @ModelAttribute("book") Book book,BindingResult result, Model model) {

		if(result.hasErrors())
		{
			return "book/edit";
		}
		MultipartFile bookImage = book.getBookImage();
		System.out.println("Book Title:");
		System.out.println(book.getTitle());

		String rootDirectory = servletContext.getRealPath("/");

		System.out.println(book.getBookImage());
		String path = "/images/" + book.getTitle() + ".png";
		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				String imagePath = rootDirectory + "/resources/" + path;
				bookImage.transferTo(new File(imagePath));
				book.setImagePath(path);
			} catch (Exception e) {
				throw new RuntimeException("Failed to save employee image.", e);
			}
		}

		Category category = categoryService.findOne(book.getCategory().getId());
		book.setCategory(category);
		
		// ra.addFlashAttribute("book",book);
		Book b = bookService.save(book);
		String imgPath="/images/"+b.getId()+".png";
		book.setImagePath(imgPath);

		return "redirect:/book";

	}

	@RequestMapping("/edit/{id}")
	public String getEdit(@PathVariable("id") int id, @ModelAttribute("book") Book book, Model model) {

		model.addAttribute("book", bookService.findOne(id));
		model.addAttribute("categoryList", categoryService.findAll());

		return "book/edit";
	}

	/*
	 * @RequestMapping(value = "/save/{id}", method = RequestMethod.POST) public
	 * String saveCategory(@PathVariable Long id, @ModelAttribute("book") Book book,
	 * Model model) {
	 * 
	 * bookService.save(book);
	 * 
	 * return "redirect:/book/"; }
	 */

	@RequestMapping(value = "details", method = RequestMethod.GET)
	public String getcategoryDetails(Model model) {

		return "bookDetails";
	}
	
	@RequestMapping(value="/books/{id}")
	public String getBookListByCategory(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("bookList", bookService.findBooksById(id));
		return "book/list";

	}

}
