package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB1_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			Book firstBook = new Book("The Java Language Specification","Gilad Bracha",99.99999f);
			Book secondBook = new Book("The Java Language Specification Second Eddition","Gilad Bracha, James Gosling",119f);
			Book thirdBook = new Book("Core Java Volume I","Cay S. Horstman",59.9999f);
		  
			entityManager.persist(firstBook);
			entityManager.persist(secondBook);
			entityManager.persist(thirdBook);
		
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
	}
}
