package com.skillsoft.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity(name="Invoices")
public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private Float amount;
	
	@OneToOne
	@MapsId
	private Order order;
	
	public Invoice() {
	}

	public Invoice(Float amount) {
		
		this.amount = amount;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "\n{" + id + "," + amount + "," + order + "}\n";
	}
}
