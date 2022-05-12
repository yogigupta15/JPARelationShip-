package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB1_Unit");
	   EntityManager entityManager = factory.createEntityManager();
	
	   try {
/*		   entityManager.getTransaction().begin();
		   
		   
		   Book firstBook = new Book("The Java Language Specification","Gilad Bracha",99.9999f);
		   Book secondBook = new Book("The Java Language Specification Second Eddition","Gilad Bracha, James Gosling",119f);
		   Book thirdBook = new Book("Core Java Volume I","Cay S. Horstman",59.9999f);
	  
		   entityManager.persist(firstBook);
		   entityManager.persist(secondBook);
		   entityManager.persist(thirdBook); 
*/  /*	   
		   Book bookOne = entityManager.find(Book.class,221);
		   System.out.println(bookOne);
		   
		   Book bookTwo = entityManager.find(Book.class,251);
		   System.out.println(bookTwo);
		   
		   Book bookThree = entityManager.find(Book.class,281);
		   System.out.println(bookThree);
*/		
		   List<Book> books = entityManager.createQuery("SELECT b from Book b",Book.class).getResultList();
		   System.out.println(books);
		   
	   }catch(Exception ex) {
		   
		   System.err.println("An exception occurred: " + ex);
		   
	   }finally {
		   
//		   entityManager.getTransaction().commit();
		   entityManager.close();
		   factory.close();
		   }
	   }
}
