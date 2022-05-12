package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	/* Referencing with Foreign key*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
		    /* By Named parameter */
			TypedQuery<Product> productQuery = entityManager.createQuery(
					"select p from Products p " + 
			        "where p.category.id = :category_id",
			        Product.class);
			productQuery.setParameter("category_id", 221);
			List<Product> products = productQuery.getResultList();
			System.out.println(products);
			
			/* By Positional Parameter */
			TypedQuery<Product> productQuery1 = entityManager.createQuery(
					"select p from Products p " + 
			        "where p.category.id = ?1",
			        Product.class);
			productQuery1.setParameter(1, 231);
			List<Product> products1 = productQuery1.getResultList();
			System.out.println(products1);
			
			TypedQuery<Product> productQuery2 = entityManager.createQuery(
					"select p from Products p " + 
			        "where p.category.id = ?1 and "+
					"p.price> ?2",
			        Product.class);
			productQuery2.setParameter(1, 231);
			productQuery2.setParameter(2, 10f);
			List<Product> products2 = productQuery2.getResultList();
			System.out.println(products2);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
