package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	/* Executing JPQL Typed-Queries using named parameters and positional parameter*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			/* by using named parameter */
			TypedQuery<Product> productQuery = entityManager.createQuery("select p from Product p where p.id = :pid",Product.class);
			productQuery.setParameter("pid", 1003);
			Product product = productQuery.getSingleResult();
			System.out.println(product);
			
			/* by using positional parameter */
			TypedQuery<Product> productQuery1 = entityManager.createQuery("select p from Product p where p.id = ?1",Product.class);
			productQuery1.setParameter(1, 1005);
			Product product1 = productQuery1.getSingleResult();
			System.out.println(product1);
			
			/* by using named parameter */
			TypedQuery<Product> productQuery2 = entityManager.createQuery("select p from Product p where p.id > :pid order by price",Product.class);
			productQuery2.setParameter("pid", 1003);
			List<Product> product2 = productQuery2.getResultList();
			System.out.println(product2);
			
			TypedQuery<Product> productQuery3 = entityManager.createQuery("select p from Product p where p.id < ?1 order by price desc",Product.class);
			productQuery3.setParameter(1, 1008);
			List<Product> product3 = productQuery3.getResultList();
			System.out.println(product3);
			
			TypedQuery<Product> productQuery4 = entityManager.createQuery("select p from Product p where p.name like :nameStartsWith",Product.class);
			productQuery4.setParameter("nameStartsWith","iPh%");
			List<Product> product4 = productQuery4.getResultList();
			System.out.println(product4);
			
			TypedQuery<Product> productQuery5 = entityManager.createQuery("select p from Product p " + "where p.name not like :nameSubString and p.price > :priceParameter",Product.class);
			productQuery5.setParameter("nameSubString","iPh%");
			productQuery5.setParameter("priceParameter", 10f);
			List<Product> product5 = productQuery5.getResultList();
			System.out.println(product5);

			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
