package com.cg.jhl2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books2")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="isbn") 
	private Long isbn;
	
	@Column(name="title") 
	private String title;
	
	@Column(name="price") 
	private double price;
	
	@ManyToOne
	@JoinColumn(name="id",nullable = false)
	private Author author;

	public Book() {
		/*default constructor*/
	}

	public Book(Long isbn, String title, double price, Author author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", price=" + price + ", author=" + author + "";
	}

}



