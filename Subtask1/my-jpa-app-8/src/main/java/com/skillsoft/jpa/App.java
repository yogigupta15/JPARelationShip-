package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		   EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDB1_Unit");
		   EntityManager entityManager = factory.createEntityManager();
		   
		   try {
			   Book bookOne = entityManager.find(Book.class, 221);
			   Book bookTwo = entityManager.find(Book.class, 251);
			   
			   System.out.println(bookOne);
			   System.out.println(bookTwo);
			   
			   entityManager.getTransaction().begin();
			   
			   bookOne.setPrice(25.22f);
			   bookTwo.setTitle("Core java Volume I - Fundamentals");
			   
			   entityManager.merge(bookOne);
			   entityManager.merge(bookTwo);
			   
			   Book bookThree = entityManager.find(Book.class, 231);
			   Book bookFour = entityManager.find(Book.class, 241);
			   
			   System.out.println(bookThree);
			   System.out.println(bookFour);

			   if(bookOne != null) {
				   entityManager.remove(bookThree);
			   }
			   if(bookOne != null) {
				   entityManager.remove(bookFour);
			   }
			   
		   }catch(Exception ex) {
			   
			   System.err.println("An exception occurred: " + ex);
			   
		   }finally {
			   
			   entityManager.getTransaction().commit();
			   
			   entityManager.close();
			   factory.close();
			   }
		   }
}
