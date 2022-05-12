package com.skillsoft.jpa;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class App {
	
	/* Selecting Multiple fields including aggregates*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
		    TypedQuery<Long> categoryQuery = entityManager.createQuery(
		    		"select count(c) from Categories c",
		    		Long.class);
		    System.out.println(categoryQuery.getSingleResult());
		    
		    TypedQuery<Double> categoryQuery1 = entityManager.createQuery(
		    		"select avg(p.price) from Products p",
		    		Double.class);
		    System.out.println(categoryQuery1.getSingleResult());
		    
		    Query aggQuery = entityManager.createQuery(
		    		"select c.name, avg(p.price) from Categories c " +
		            "inner join c.products p group by c.name");
		    
		    @SuppressWarnings("unchecked")
		    List<Object[]> resultList = aggQuery.getResultList();
		    
		    System.out.println();
		    resultList.forEach(r -> System.out.println(Arrays.toString(r)));
		    
		    Query aggQuery1 = entityManager.createQuery(
		    		"select c.name, max(p.price) from Categories c " +
		            "inner join c.products p group by c.name " +
		    		"having max(p.price) > ?1");
		    
		    aggQuery1.setParameter(1, 80f);
		    
		    @SuppressWarnings("unchecked")
		    List<Object[]> resultList1 = aggQuery1.getResultList();
		    
		    System.out.println();
		    resultList1.forEach(r -> System.out.println(Arrays.toString(r)));
		    
		    /* Using SubQuery */
		    Query query = entityManager.createQuery(
		    		"select c.name, c.id from Categories c " +
		            "where exists" +
		    		"(select p from Products p where p.price > ?1 and p.category.id = c.id)");
		    query.setParameter(1, 80f);
		    @SuppressWarnings("unchecked")
		    List<Object[]> resultList2 = query.getResultList();
		    
		    System.out.println();
		    resultList2.forEach(r -> System.out.println(Arrays.toString(r)));
		    	
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
