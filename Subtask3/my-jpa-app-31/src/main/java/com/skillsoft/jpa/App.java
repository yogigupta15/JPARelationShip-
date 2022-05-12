package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	/* Executing native queries */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			Query query = entityManager.createNativeQuery("select * from categories",Category.class);
			List<Category> categories = (List<Category>)query.getResultList();
			categories.forEach(System.out::println);
			
			query = entityManager.createNativeQuery("select * from products",Product.class);
			List<Product> products = (List<Product>)query.getResultList();
			products.forEach(System.out::println);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
