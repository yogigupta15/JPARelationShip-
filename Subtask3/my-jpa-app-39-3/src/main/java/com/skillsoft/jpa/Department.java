package com.skillsoft.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity(name="departments")
public class Department implements Serializable {
	 public static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String name;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "department_id")
	 private Set<Employee> employees;
	 
	 public Department() {
		 
	 }

	public Department(String name) {
		
		this.name = name;
	}
	/* persist callback */
	@PrePersist
	public void onPrePersist() {
		System.out.println("\n********** Before persisting deparment object: " + name);
	}
	
	@PostPersist
	public void onPostPersist() {
		System.out.println("\n********** After persisting deparment object: " + name);
	}
	
	@PostLoad
	void onPostLoad() {
		System.out.println("\n********** After loading deparment object: " + name);
	}
	
	@PreUpdate
	void onPreUpdate() {
		System.out.println("\n********** Before updating deparment object: " + name);
	}
	
	@PostUpdate
	void onPostUpdate() {
		System.out.println("\n********** After updating deparment object: " + name);
	}
	@PreRemove
	void onPreRemove() {
		System.out.println("\n********** Before removing deparment object: " + name);
	}
	@PostRemove
	void onPostRemove() {
		System.out.println("\n********** After removing deparment object: " + name);
	}
	public Set<Employee> getEmployees() {
		return employees;
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
	
	public void addEmployee(Employee employee) {
		
		if(employees == null) {
			employees = new HashSet<>();
		}
		employees.add(employee);
	}
	@Override
	public String toString() {
		return "Name: " + name + "Employees: " + employees;
	}
}
