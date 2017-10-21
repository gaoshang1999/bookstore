package edu.mum.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class BookImage {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String imagePath;
	@Transient
	private MultipartFile bookImage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public MultipartFile getBookImage() {
		return bookImage;
	}
	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}
}
