package com.cg.jhl2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="Authors")
	
	public class Author implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
		private List<Book> book;
		
		public Author() {
			
		}
		
		public Author(String name, List<Book> book) {
			super();
			this.name = name;
			this.book = book;
		}
		
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public List<Book> getBook() {
			return book;
		}
		
		public void setBook(List<Book> book) {
			this.book = book;
		}
		
		@Override
		public String toString() {
			 
			return  "\t"+id+"\t"+name+"\t";
		}
		
}

