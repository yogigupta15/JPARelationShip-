package com.skillsoft.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompanyDB_Unit");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
/*			Department tech = entityManager.find(Department.class,1);
			System.out.println(tech);
			
			Department operations = entityManager.find(Department.class,2);
			System.out.println(operations);
*/
			
			TypedQuery<Department> deptQuery = entityManager.createQuery(
					"select d from departments d",Department.class);
			
			List<Department> deptList = deptQuery.getResultList();
			
			System.out.println(deptList);
			
			TypedQuery<Employee> empQuery = entityManager.createQuery(
					"select e from employees e",Employee.class);
			
			List<Employee> empList = empQuery.getResultList();
			
			System.out.println(empList);
			
		}catch(Exception ex) {
			
			System.err.println("An exception occurred: " + ex);
			
		}finally {
			
			entityManager.close();
			factory.close();
		}
	}
}
