package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		/* working with callback  using Listener class*/
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			Employee alice = new Employee("Alice");
			Employee ben = new Employee("Ben");
			Employee cora = new Employee("Cora");
			Employee dennis = new Employee("Dennis");
			
			Department tech = new Department("Tech");
			tech.addEmployee(alice);
			tech.addEmployee(ben);
			
			Department operations = new Department("Operations");
			operations.addEmployee(cora);
			operations.addEmployee(dennis);
			
			entityManager.persist(tech);
			entityManager.persist(operations);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
	}
}
