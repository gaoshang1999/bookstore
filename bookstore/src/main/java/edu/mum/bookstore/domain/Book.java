package edu.mum.bookstore.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;



@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="Book title can not be empty!")
	private String title;
	@Size(min=50,max=2000,message="Book description can not be less than 50 characters!")
	private String description;
	@NotNull
	private double price;
	
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/*@Transient
    private  MultipartFile bookImage;	
    
	

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}*/
    @NotNull
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="categoryId")
    
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
