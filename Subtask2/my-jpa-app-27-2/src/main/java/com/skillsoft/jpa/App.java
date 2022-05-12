package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	/*  Many to ONE Mapping by join Tables */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			Product productOne = entityManager.find(Product.class,1);
			System.out.println(productOne);
			System.out.println(productOne.getOrder());
			
			Product productFive = entityManager.find(Product.class,5);
			System.out.println(productFive);
			System.out.println(productFive.getOrder());
			
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		} finally {
			
			entityManager.close();
			factory.close();
		}
		
	}	
}
