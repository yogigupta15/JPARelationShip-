package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		/* working with update callback */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			Department tech = entityManager.find(Department.class,1);
			tech.setName("Engineering");
			entityManager.merge(tech);
			
			Department operations = entityManager.find(Department.class,2);
			tech.setName("Ops");
			entityManager.merge(operations);
			
			Department operations1 = entityManager.find(Department.class,2);
			operations1.setName("operations");
			Employee elise = new Employee("Elise");
			operations1.addEmployee(elise);
			entityManager.merge(operations1);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
	}
}
