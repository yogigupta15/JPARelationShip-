package com.skillsoft.jpa;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	/* ONE to Many Mapping and performing OrderBy */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			Product productOne = new Product("iPhone 6S",1);
			Product productTwo = new Product("Nike Sneakers",2);
			
			List<Product> listOne = new ArrayList<>();
			listOne.add(productTwo);
			listOne.add(productOne);
			
			Order orderOne = new Order(listOne,new GregorianCalendar(2020,1,3).getTime());
			
			Product productThree = new Product("Samsung Galaxy",1);
			Product productFour = new Product("Crocs",1);
			Product productFive = new Product("BenQ Mointors",4);
			
			List<Product> listTwo = new ArrayList<>();
			listTwo.add(productFive);
			listTwo.add(productFour);
			listTwo.add(productThree);
			
			Order orderTwo = new Order(listTwo,new GregorianCalendar(2020,2,5).getTime());
			
			entityManager.persist(orderOne);
			entityManager.persist(orderTwo);
			
			entityManager.persist(productOne);
			entityManager.persist(productTwo);
			entityManager.persist(productThree);
			entityManager.persist(productFour);
			entityManager.persist(productFive);
			
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		} finally {
			
			entityManager.getTransaction().commit();
			
			entityManager.close();
			factory.close();
		}
		
	}	
}
