package com.skillsoft.jpa;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EmployeeListener {
	
	@PrePersist
	public void onPrePersist(Employee employee) {
		System.out.println("\n********** Before persisting employee object: " + employee.getName());
	}
	
	@PostPersist
	public void onPostPersist(Employee employee) {
		System.out.println("\n********** After persisting employee object: " + employee.getName());
	}
	
	@PostLoad
	void onPostLoad(Employee employee) {
		System.out.println("\n********** After loading employee object: " + employee.getName());
	}
	
	@PreUpdate
	void onPreUpdate(Employee employee) {
		System.out.println("\n********** Before updating employee object: " + employee.getName());
	}
	
	@PostUpdate
	void onPostUpdate(Employee employee) {
		System.out.println("\n********** After updating employee object: " + employee.getName());
	}
	
	@PreRemove
	void onPreRemove(Employee employee) {
		System.out.println("\n********** Before removing employee object: " + employee.getName());
	}
	@PostRemove
	void onPostRemove(Employee employee) {
		System.out.println("\n********** After removing employee object: " + employee.getName());
	}
}
