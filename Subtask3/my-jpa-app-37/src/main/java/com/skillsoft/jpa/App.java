package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	
	/* Using Named Queries*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			TypedQuery<Product> productQuery1 = entityManager.createNamedQuery(
					Product.SELECT_PRODUCTS_IN_CATEGORY, Product.class);
			productQuery1.setParameter("categoryId",231);
			System.out.println(productQuery1.getResultList());
			
			TypedQuery<Product> productQuery2= entityManager.createNamedQuery(
					Product.SELECT_PRODUCTS_IN_PRICE_RANGE, Product.class);
			productQuery2.setParameter("low",100f);
			productQuery2.setParameter("high",1000f);
			System.out.println(productQuery2.getResultList());
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			entityManager.close();
			factory.close();
		}
}
}
