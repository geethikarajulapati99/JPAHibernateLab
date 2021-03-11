package com.cg.jhl2.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jhl2.entity.Author;
import com.cg.jhl2.entity.Book;

public class App1 {

	public static void main(String[] args) {
		 
		EntityManagerFactory factory=Persistence.createEntityManagerFactory(null);
		EntityManager em=factory.createEntityManager();
		
		System.out.println(" [1]. All Books ");
		Query query = em.createQuery("Select book FROM Book book");
		
		List<Book> books = query.getResultList();
		for(Book book:books) {
			System.out.println(book);
		}
		
		System.out.println("[2]. Books By Author Name");
		
		String qStr = "SELECT author FROM Author author where author.name=:pAuthor";
		TypedQuery<Author> que = em.createQuery(qStr,Author.class);
		que.setParameter("pAuthor", "John Green");
		Author author = que.getSingleResult();
		Long authorID = author.getId();
		
		String QueryStr = "SELECT book FROM Book book, Author author where book.author.id=:pID";
		TypedQuery<Book> bookList = em.createQuery(QueryStr,Book.class);
		bookList.setParameter("pID", authorID);
		List<Book> bookList1 = bookList.getResultList();
		for(Book book: bookList1) {
			System.out.println(book);
		}
		
		
		System.out.println(" [3]. Books price Range btwn 500-1000");

		String qStrng = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Book> tqry = em.createQuery(qStrng,Book.class);
		tqry.setParameter("low", 400.0);
		tqry.setParameter("high", 1000.0);
		List<Book> bookList2 = tqry.getResultList();
		for(Book book:bookList2) {
			System.out.println(book);
		}
		
		System.out.println("[4]. Author-By-Book-ID ");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book ID");
		int id = s.nextInt();
		String queryGetById = "Select author.name from Author author, Book book where author.id=(Select book.author.id from Book book where book.isbn=:pID)";
	
		Query  q= em.createQuery(queryGetById);
		q.setParameter("pID", id);
		List<Book> li = q.getResultList();
		System.out.println("Auhtor Name : "+li.get(0));
		
		System.out.println("[ Lab 4 Done ]\n\n");
		
		em.close();
		factory.close();
		s.close();
		
		System.out.println("\n\n[ Connection Cleaned Up! ]");
	}

}
