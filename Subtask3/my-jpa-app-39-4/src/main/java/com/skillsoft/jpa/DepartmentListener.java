package com.skillsoft.jpa;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class DepartmentListener {
	
	@PrePersist
	public void onPrePersist(Department department) {
		System.out.println("\n********** Before persisting deparment object: " + department.getName());
	}
	
	@PostPersist
	public void onPostPersist(Department department) {
		System.out.println("\n********** After persisting deparment object: " + department.getName());
	}
	
	@PostLoad
	void onPostLoad(Department department) {
		System.out.println("\n********** After loading deparment object: " + department.getName());
	}
	
	@PreUpdate
	void onPreUpdate(Department department) {
		System.out.println("\n********** Before updating deparment object: " + department.getName());
	}
	
	@PostUpdate
	void onPostUpdate(Department department) {
		System.out.println("\n********** After updating deparment object: " + department.getName());
	}
	@PreRemove
	void onPreRemove(Department department) {
		System.out.println("\n********** Before removing deparment object: " + department.getName());
	}
	@PostRemove
	void onPostRemove(Department department) {
		System.out.println("\n********** After removing deparment object: " + department.getName());
	}
}
