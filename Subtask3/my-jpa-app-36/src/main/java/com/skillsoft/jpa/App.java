package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	
	/* Performing update and Delete queries*/
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnlineShoppDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			Query updateQuery = entityManager.createQuery(
					"update Products p set p.name = 'Gel Pens' where p.name = :name ");
			
			updateQuery.setParameter("name", "Pen");
			
			int rowsUpdated = updateQuery.executeUpdate();
			
			System.out.println("\n\nNumber of Rows updated: " + rowsUpdated);
			
			Query updateQuery1 = entityManager.createQuery(
					"update Categories c set c.name = " +
			           "case " +
						"when c.id = 221 then 'Mobiles and Accessories' " +
			            "when c.id =241 then 'Home and kitchen' " +
						"else c.name " +
			            "end");
			
			int rowsUpdated1 = updateQuery1.executeUpdate();
			
			System.out.println("\n\nNumber of Rows updated: " + rowsUpdated1);
			
			/* Delete Query */
			Query deleteQuery = entityManager.createQuery(
					"delete Products p where p.id > :id ");
			deleteQuery.setParameter("id", 1008);
			int rowsDeleted = deleteQuery.executeUpdate();
			System.out.println("\n\nNumber of Rows deleted: " + rowsDeleted);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
}
}
