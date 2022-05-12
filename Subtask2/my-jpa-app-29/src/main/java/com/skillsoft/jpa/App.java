package com.skillsoft.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	/* Many To Many Mapping */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppingDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			Product productIphone = new Product ("iPhone 6S");
			Product productNike = new Product("Nike Sneakers");
			Product productCrocs = new Product("Crocs");	
			Product productBenq = new Product("BenQ Monitors");		
			Product productSamsung = new Product("Samsung Galaxy");
			
			List<Product> listJohn = new ArrayList<>();
			List<Product> listJulie = new ArrayList<>();
			List<Product> listBen = new ArrayList<>();
			
			listJohn.add(productIphone);
			listJulie.add(productNike);
			listBen.add(productCrocs);
			
			Customer customerJohn = new Customer("John",listJohn);
			
			listJulie.add(productIphone);
			listJulie.add(productSamsung);
		    
			Customer customerJulie = new Customer("Julie",listJulie);
			
			listBen.add(productIphone);
			listBen.add(productBenq);
			listBen.add(productCrocs);
			
			Customer customerBen = new Customer("Ben",listBen);
			
			entityManager.persist(customerJohn);
			entityManager.persist(customerJulie);
			entityManager.persist(customerBen);
			
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
