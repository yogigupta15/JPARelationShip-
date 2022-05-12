package com.skillsoft.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="Products")
@NamedQueries({
	@NamedQuery(name = Product.SELECT_PRODUCTS_IN_CATEGORY,
			query="select p from Products p where p.category.id = :categoryId"),
	@NamedQuery(name = Product.SELECT_PRODUCTS_IN_PRICE_RANGE,
	        query="select p from Products p where p.price >= :low and p.price <= :high")
})
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
    public static final String SELECT_PRODUCTS_IN_CATEGORY = "selectProductsInCategory";
	public static final String SELECT_PRODUCTS_IN_PRICE_RANGE = "selectProductsInPriceRange";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Float price;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Product() {
		
	}

	public Product(String name, Float price) {
		
		this.name = name;
		this.price = price;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "\n{" + id + "," + name + "," + price + "}\n";
	}
}
