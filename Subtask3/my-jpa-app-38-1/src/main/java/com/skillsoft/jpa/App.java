package com.skillsoft.jpa;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class App {
	
	/* Criteria API and running Advance criteria queries */
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
/*			CriteriaQuery<String> productCQ = cb.createQuery(String.class);
			
			Root<Product> rootProduct = productCQ.from(Product.class);
			
			productCQ.select(rootProduct.get("name"));
			
			TypedQuery<String> productQuery = entityManager.createQuery(productCQ);
			
			productQuery.getResultList().forEach(System.out::println);
*/			
/*			CriteriaQuery<Object[]> productCQ = cb.createQuery(Object[].class);
			
			Root<Product> rootProduct = productCQ.from(Product.class);
			
//			productCQ.select(cb.array(rootProduct.get("name"),rootProduct.get("price")));
			productCQ.multiselect(rootProduct.get("name"),rootProduct.get("price"));  for selecting multiple column we use multiselect 
						
			TypedQuery<Object[]> productQuery = entityManager.createQuery(productCQ);
			
			productQuery.getResultList().forEach(r ->System.out.println(Arrays.toString(r)));			
*/
			CriteriaQuery<Object[]> productCQ = cb.createQuery(Object[].class);
			
			Root<Product> rootProduct = productCQ.from(Product.class);
			
			productCQ.multiselect(rootProduct.get("category"), cb.count(rootProduct))
			.groupBy(rootProduct.get("category"));
			
			TypedQuery<Object[]> productQuery = entityManager.createQuery(productCQ);
			
			productQuery.getResultList().forEach(r ->System.out.println(Arrays.toString(r)));
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {

			entityManager.close();
			factory.close();
		}
}
}
