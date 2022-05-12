package com.skillsoft.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity(name="employees")
public class Employee implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="deparment_id")
	private Department department;
	
	public Employee() {
		
	}

	public Employee(String name) {
		
		this.name = name;
	}
	/* persist callback */
	@PrePersist
	public void onPrePersist() {
		System.out.println("\n********** Before persisting employee object: " + name);
	}
	
	@PostPersist
	public void onPostPersist() {
		System.out.println("\n********** After persisting employee object: " + name);
	}
	
	@PostLoad
	void onPostLoad() {
		System.out.println("\n********** After loading employee object: " + name);
	}
	
	@PreUpdate
	void onPreUpdate() {
		System.out.println("\n********** Before updating employee object: " + name);
	}
	
	@PostUpdate
	void onPostUpdate() {
		System.out.println("\n********** After updating employee object: " + name);
	}
	
	@PreRemove
	void onPreRemove() {
		System.out.println("\n********** Before removing employee object: " + name);
	}
	@PostRemove
	void onPostRemove() {
		System.out.println("\n********** After removing employee object: " + name);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Name:" + name;
	}
}
