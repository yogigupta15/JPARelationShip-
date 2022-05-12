package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		/* working with remove  callback */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Employee employee = entityManager.find(Employee.class,3);
			entityManager.remove(employee);
			
			Department department = entityManager.find(Department.class,2);
			entityManager.remove(department);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
	}
}
