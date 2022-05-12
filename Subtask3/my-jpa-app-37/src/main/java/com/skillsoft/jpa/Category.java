package com.skillsoft.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity(name="Categories")
@NamedQuery(name=Category.SELECT_SPECIFIC_CATEGORY,
query="select c from Categories c where c.name = :categoryName ")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String SELECT_SPECIFIC_CATEGORY = "selectSpecificCategory";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Set<Product>products;
	
	public Category() {
		
	}

	public Category(String name) {
		
		this.name = name;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		if(products == null) {
			products = new HashSet<>();
		}
		products.add(product);
	}
	@Override
	public String toString() {
		return "\n{" + id + "," + name + "," + products + "}\n";
	}
}
