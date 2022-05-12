package com.skillsoft.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "author_name", length = 44,nullable = false,unique = true )
	private String name;
	
//	@Transient
	@Column(name="birth_date")
//	@Temporal(TemporalType.DATE)
//	@Temporal(TemporalType.TIME)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	public Author() {
	}
	
	public Author(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
