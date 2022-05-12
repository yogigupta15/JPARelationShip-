package com.skillsoft.jpa;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
    public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB1_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			Book firstBook = new Book("The Java Language Specification","Gilad Bracha",99f);
			Book secondBook = new Book("The Java Language Specification Second Eddition","Gilad Bracha, James Gosling",119f);
			Book thirdBook = new Book();
		  
			entityManager.persist(firstBook);
			entityManager.persist(secondBook);
			entityManager.persist(thirdBook);
			
			Author firstAuthor = new Author("Gilad Bracha",new GregorianCalendar(1980,1,0).getTime());
			Author secondAuthor = new Author("James Gosling",new GregorianCalendar(1975,2,0).getTime());
			
			entityManager.persist(firstAuthor);
			entityManager.persist(secondAuthor);
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
	}
}
