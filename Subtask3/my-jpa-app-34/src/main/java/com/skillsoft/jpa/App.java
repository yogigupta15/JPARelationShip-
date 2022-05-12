package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	
	/*Performing Inner Join*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
		    TypedQuery<Category> categoryQuery = entityManager.createQuery(
		    		"select c from Categories c " +
		            "inner join c.products",
		    	     Category.class);
		    List<Category> categories = categoryQuery.getResultList();
		    System.out.println(categories);
		    
		    TypedQuery<Category> categoryQuery1 = entityManager.createQuery(
		    		"select c from Categories c " +
		            "inner join c.products p " +
		    		"where p.price > ?1 " ,
		    	     Category.class);
		    categoryQuery1.setParameter(1, 90f);
		    List<Category> categories1 = categoryQuery1.getResultList();
		    System.out.println(categories1);
		    
		    TypedQuery<Category> categoryQuery2 = entityManager.createQuery(
		    		"select c from Categories c " +
		            "inner join c.products p " +
		    		"where c.name = ?1 " +
		            "and p.price > ?2",
		    	     Category.class);
		    categoryQuery2.setParameter(1,"Fashion");
		    categoryQuery2.setParameter(2, 60f);
		    List<Category> categories2 = categoryQuery2.getResultList();
		    System.out.println(categories2);
		    
		    /* using Fetch */
		    TypedQuery<Category> categoryQuery3 = entityManager.createQuery(
		    		"select c from Categories c " +
		            "inner join fetch c.products p " +
		    		"where c.name = ?1 " +
		            "and p.price > ?2",
		    	     Category.class);
		    categoryQuery3.setParameter(1,"Fashion");
		    categoryQuery3.setParameter(2, 60f);
		    List<Category> categories3 = categoryQuery3.getResultList();
		    System.out.println(categories3);
		    
		    /* using multiple Positional parameter */
		    TypedQuery<Category> categoryQuery4 = entityManager.createQuery(
		    		"select c from Categories c " +
		            "inner join fetch c.products p " +
		    		"where p.name in (?1, ?2, ?3)" ,
		    	     Category.class);
		    categoryQuery4.setParameter(1,"Samsung Galaxy");
		    categoryQuery4.setParameter(2, "Jeans");
		    categoryQuery4.setParameter(3, "Notebook");
		    List<Category> categories4 = categoryQuery4.getResultList();
		    System.out.println(categories4);
		    	
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
