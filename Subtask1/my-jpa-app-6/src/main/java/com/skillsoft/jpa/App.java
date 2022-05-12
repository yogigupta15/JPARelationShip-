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
			
			Book firstBook = new Book("The Java Language Specification","Gilad Bracha",99.9999f);
			Book secondBook = new Book("The Java Language Specification Second Eddition","Gilad Bracha, James Gosling",119f);
			Book thirdBook = new Book("Core Java Volume I","Cay S. Horstman",59.9999f);
		  
			entityManager.persist(firstBook);
			entityManager.persist(secondBook);
			entityManager.persist(thirdBook);
			
			Author firstAuthor = new Author("Gilad Bracha",new GregorianCalendar(1980,1,0).getTime());
			firstAuthor.setBio("Some very long personal bio here");
			firstAuthor.setImage("Pretend this is an image".getBytes());
			Address firstAddress = new Address("New York","USA");
			firstAuthor.setAddress(firstAddress);
			
			Author secondAuthor = new Author("James Gosling",new GregorianCalendar(1975,2,0).getTime());
			secondAuthor.setImage("Pretend this is an image".getBytes());
			Address secondAddress = new Address("San Francisco","USA");
			secondAuthor.setAddress(secondAddress);
			
			entityManager.persist(firstAuthor);
			entityManager.persist(secondAuthor);
			
			Publisher firstPublisher = new Publisher("Apress");
			firstAddress = new Address("Paris","France");
			firstPublisher.setAddress(firstAddress);
			
			Publisher secondPublisher = new Publisher("Manning");
			
			entityManager.persist(firstPublisher);
			entityManager.persist(secondPublisher);
			
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
		}
}
