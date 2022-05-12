package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	/* Bidirectional ONE to ONE Mapping*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			

			Invoice invoiceOne = entityManager.find(Invoice.class, 1);
			System.out.println(invoiceOne);
			
			Invoice invoiceTwo = entityManager.find(Invoice.class, 2);
			System.out.println(invoiceTwo);
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		} finally {
			
			entityManager.close();
			factory.close();
		}
	}
}
