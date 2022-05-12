package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	/* Many To Many Mapping */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
		/*	Customer customerOne = entityManager.find(Customer.class, 1);
			System.out.println(customerOne);
			System.out.println(customerOne.getProducts());
			
			Customer customerThree = entityManager.find(Customer.class,3);
			System.out.println(customerThree);
			System.out.println(customerThree.getProducts());  */
			
			Product productOne = entityManager.find(Product.class,1);
			System.out.println(productOne);
			System.out.println(productOne.getCustomers());
			
			Product productFive = entityManager.find(Product.class,5);
			System.out.println(productFive);
			System.out.println(productFive.getCustomers());
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		} finally {
			
			entityManager.close();
			factory.close();
		}
		
	}	
}
