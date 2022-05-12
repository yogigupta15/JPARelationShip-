package com.skillsoft.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	@JoinTable(name="order_product_mapping",
	joinColumns = { @JoinColumn(name = "o_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "p_id",referencedColumnName = "id")})
	private List<Product> products;
		
	@Temporal(TemporalType.DATE)
	private Date orderDate;
		
	public Order(){
		
	}

	public Order(List<Product> products,Date orderDate) {

		this.products = products;
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProduct() {
		return products;
	}

	public void setProduct(List<Product> products) {
		this.products = products;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	@Override
	public String toString() {
		return "\n{" + id  + "," + products + ","  +  "}\n";
	}
	
}
