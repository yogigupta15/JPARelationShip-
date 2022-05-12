package com.skillsoft.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="customers_products",
	joinColumns= {@JoinColumn(name="customer_id",referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="product_id",referencedColumnName = "id")})
	private List<Product> products;
	
	public Customer() {
	}

	public Customer(String name, List<Product> products) {
		
		this.name = name;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "\n{" + id + "," + name + "}\n";
	}
	
}
