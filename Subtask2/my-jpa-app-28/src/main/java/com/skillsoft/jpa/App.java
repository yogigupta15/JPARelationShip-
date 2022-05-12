package com.skillsoft.jpa;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	/* Configuring the owning side and owned side */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			Product productIphone = new Product ("iPhone 6S",1);
			Product productNike = new Product("Nike Sneakers",2);
			
			List<Product> listOne = new ArrayList<>();
			listOne.add(productIphone);
			listOne.add(productNike);
			
			Order orderOne = new Order(listOne, new GregorianCalendar(2020,1,3).getTime());
			
			Product productSamsung = new Product("Samsung Galaxy",1);
			Product productCrocs = new Product("Crocs",1);
			Product productBenq = new Product("BenQ Monitors",4);
			
			List<Product> listTwo = new ArrayList<>();
			listTwo.add(productSamsung);
			listTwo.add(productCrocs);
			listTwo.add(productBenq);
			
			Order orderTwo = new Order(listTwo, new GregorianCalendar(2020,1,3).getTime());
			
			entityManager.persist(orderOne);
			entityManager.persist(orderTwo);
			
			entityManager.persist(productIphone);
			entityManager.persist(productNike);
			entityManager.persist(productSamsung);
			entityManager.persist(productCrocs);
			entityManager.persist(productBenq);
			
			
		} catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		} finally {
			
			entityManager.getTransaction().commit();
			
			entityManager.close();
			factory.close();
		}
		
	}	
}
