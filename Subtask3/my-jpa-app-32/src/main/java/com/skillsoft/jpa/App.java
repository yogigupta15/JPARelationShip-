package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	/* Executing JPAL-Queries */
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			Query categoryQuery = entityManager.createQuery("select c from Categories c");
			List<?> categories = categoryQuery.getResultList();
			categories.forEach(System.out::println);
			
			Query productQuery = entityManager.createQuery("select p from Product p");
			List<?> products = productQuery.getResultList();
			products.forEach(System.out::println);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
