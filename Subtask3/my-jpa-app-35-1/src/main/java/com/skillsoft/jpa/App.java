package com.skillsoft.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	
	/* Constructing Objects in JPQL Queries*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
		    TypedQuery<CategoryPrice> aggQuery = entityManager.createQuery(
		    		"select new com.skillsoft.jpa.CategoryPrice(c.name,avg(p.price))" +
		    		"from Categories c " +
		    		"inner join c.products p group by c.name", CategoryPrice.class);
		    List<CategoryPrice> resultList = aggQuery.getResultList();
		    System.out.println();
		    resultList.forEach(r -> System.out.println(r));
		    	
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
}
}
