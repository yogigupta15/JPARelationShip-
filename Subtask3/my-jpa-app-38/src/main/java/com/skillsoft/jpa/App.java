package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class App {
	
	/* Criteria API and running basic criteria queries */
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<Category> categoryCQ = cb.createQuery(Category.class);
			
			Root<Category> rootCategory = categoryCQ.from(Category.class);
			
			categoryCQ.select(rootCategory);
			
			TypedQuery<Category> categoryQuery = entityManager.createQuery(categoryCQ);
			
			System.out.println(categoryQuery.getResultList());
			
			/*  Getting Only Products */
			
			CriteriaBuilder cb1 = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<Product> productCQ = cb1.createQuery(Product.class);
			
			Root<Product> rootProduct = productCQ.from(Product.class);
			
//			productCQ.select(rootProduct).where(cb1.equal(rootProduct.get("id"),1011));
//			productCQ.select(rootProduct).where(cb1.greaterThan(rootProduct.get("price"),20));
//			productCQ.select(rootProduct).orderBy(cb1.asc(rootProduct.get("price")));
			
			Predicate equalToPredicate = cb1.equal(rootProduct.get("category"),261);
			productCQ.select(rootProduct).where(equalToPredicate.not());
			
			TypedQuery<Product> productQuery = entityManager.createQuery(productCQ);
			
			System.out.println(productQuery.getResultList());
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {

			entityManager.close();
			factory.close();
		}
}
}
